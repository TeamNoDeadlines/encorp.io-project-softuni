package com.NoDeadlines.SoftUniFestApp2023.mapper;

import com.NoDeadlines.SoftUniFestApp2023.models.DTOs.*;
import com.NoDeadlines.SoftUniFestApp2023.models.*;

public class ModelMapper {

//    public UserDTO toUserDTO(User user) {
//        UserDTO userDTO = new UserDTO();
//        userDTO.setId(user.getId());
//        userDTO.setEmail(user.getEmail());
//        userDTO.setPassword(user.getPassword());
//        return userDTO;
//    }

    public ClientUserDTO toClientUserDTO(ClientUser clientUser) {
        ClientUserDTO clientUserDTO = new ClientUserDTO();
        clientUserDTO.setId(clientUser.getId());
        clientUserDTO.setEmail(clientUser.getEmail());
        clientUserDTO.setPassword(clientUser.getPassword());
        clientUserDTO.setFirstName(clientUser.getFirstName());
        clientUserDTO.setLastName(clientUser.getLastName());
        return clientUserDTO;
    }

    public BusinessUserDTO toBusinessUserDTO(BusinessUser businessUser) {
        BusinessUserDTO businessUserDTO = new BusinessUserDTO();
        businessUserDTO.setId(businessUser.getId());
        businessUserDTO.setEmail(businessUser.getEmail());
        businessUserDTO.setPassword(businessUser.getPassword());
        businessUserDTO.setName(businessUser.getName());
        return businessUserDTO;
    }

    public ProductDTO toProductDTO(Product product) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(product.getId());
        productDTO.setPrice(product.getPrice());
        productDTO.setProductName(product.getProductName());
        productDTO.setDescription(product.getDescription());
        return productDTO;
    }

    public StripeTransactionDTO toStripeTransactionDTO(StripeTransaction stripeTransaction) {
        StripeTransactionDTO stripeTransactionDTO = new StripeTransactionDTO();
        stripeTransactionDTO.setId(stripeTransaction.getId());
        stripeTransactionDTO.setBusinessUser(toBusinessUserDTO(stripeTransaction.getBusinessUser()));
        stripeTransactionDTO.setClientUser(toClientUserDTO(stripeTransaction.getClientUser()));
        stripeTransactionDTO.setProduct(toProductDTO(stripeTransaction.getProduct()));
        // ... set other attributes as needed
        return stripeTransactionDTO;
    }




    public static ProductDTO convertToDto(Product product) {
        ProductDTO dto = new ProductDTO();
        dto.setId(product.getId());
        dto.setProductName(product.getProductName());
        dto.setDescription(product.getDescription());
        dto.setPrice(product.getPrice());
        return dto;
    }

    public static Product convertToEntity(ProductDTO dto) {
        Product product = new Product();
        product.setId(dto.getId());
        product.setProductName(dto.getProductName());
        product.setDescription(dto.getDescription());
        product.setPrice(dto.getPrice());
        return product;
    }


    public static StripeTransactionDTO convertToDto(StripeTransaction transaction) {
        StripeTransactionDTO dto = new StripeTransactionDTO();
        dto.setId(transaction.getId());
        dto.setPaymentAmount(transaction.getPaymentAmount());
        dto.setPaymentStatus(transaction.getPaymentStatus());
        dto.setQuantity(transaction.getQuantity());
        return dto;
    }

    public static StripeTransaction convertToEntity(StripeTransactionDTO dto) {
        StripeTransaction transaction = new StripeTransaction();
        transaction.setId(dto.getId());
        transaction.setPaymentAmount(dto.getPaymentAmount());
        transaction.setPaymentStatus(dto.getPaymentStatus());
        transaction.setQuantity(dto.getQuantity());
        return transaction;
    }



}
