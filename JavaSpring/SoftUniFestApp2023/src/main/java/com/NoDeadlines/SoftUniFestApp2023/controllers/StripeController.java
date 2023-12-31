package com.NoDeadlines.SoftUniFestApp2023.controllers;

import java.util.HashMap;
import java.util.Map;

import com.NoDeadlines.SoftUniFestApp2023.models.CheckoutPayment;
import com.fasterxml.jackson.core.JsonProcessingException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.checkout.Session;
import com.stripe.param.checkout.SessionCreateParams;

@RestController
@RequestMapping(value = "/api")
public class StripeController {

    @PostMapping("/payment")
    public ResponseEntity<String> paymentWithCheckoutPage(@RequestBody CheckoutPayment payment) {
        try {
            // We initialize stripe object with the api key
            init();

            // We create a stripe session parameters
            SessionCreateParams params = SessionCreateParams.builder()
                    .addPaymentMethodType(SessionCreateParams.PaymentMethodType.CARD)
                    .setMode(SessionCreateParams.Mode.PAYMENT)
                    .setSuccessUrl(payment.getSuccessUrl())
                    .setCancelUrl(payment.getCancelUrl())
                    .addLineItem(
                            SessionCreateParams.LineItem.builder()
                                    .setQuantity(payment.getQuantity())
                                    .setPriceData(
                                            SessionCreateParams.LineItem.PriceData.builder()
                                                    .setCurrency(payment.getCurrency())
                                                    .setUnitAmount(payment.getAmount())
                                                    .setProductData(
                                                            SessionCreateParams.LineItem.PriceData.ProductData.builder()
                                                                    .setName(payment.getName())
                                                                    .build())
                                                    .build())
                                    .build())
                    .build();

            // create a stripe session
            Session session = Session.create(params);

            // We get the sessionId and we putted inside the response data
            // you can get more info from the session object
            Map<String, String> responseData = new HashMap<>();
            responseData.put("id", session.getId());

            // Convert map to JSON string using Jackson
            ObjectMapper objectMapper = new ObjectMapper();
            String responseJson = objectMapper.writeValueAsString(responseData);

            return ResponseEntity.ok(responseJson);
        } catch (StripeException | JsonProcessingException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to create payment session");
        }
    }

    private static void init() {
        Stripe.apiKey = "sk_test_51O5kcKImUtT79mvB14n0fpSpFkJjrREeuyHvlMj4A95tedTO4IZXCcrYav0KQ0O3xve918B7sit2CPlScZqiKKef00cW1hl4Wj";
    }
}

