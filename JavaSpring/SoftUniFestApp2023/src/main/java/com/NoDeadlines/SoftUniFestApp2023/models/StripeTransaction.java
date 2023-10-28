package com.NoDeadlines.SoftUniFestApp2023.models;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "stripe_transactions")
public class StripeTransaction {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transaction_id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "business_user_id")
    private BusinessUser businessUser;

    @ManyToOne
    @JoinColumn(name = "client_user_id")
    private ClientUser clientUser;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @Column(name = "payment_amount")
    private float paymentAmount;

    @Column(name = "payment_status", length = 11)
    private String paymentStatus;

    @Column(name = "quantity")
    private int quantity;

    public float getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(float paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BusinessUser getBusinessUser() {
        return businessUser;
    }

    public void setBusinessUser(BusinessUser businessUser) {
        this.businessUser = businessUser;
    }

    public ClientUser getClientUser() {
        return clientUser;
    }

    public void setClientUser(ClientUser clientUser) {
        this.clientUser = clientUser;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StripeTransaction that)) return false;
        return id == that.id && Objects.equals(businessUser, that.businessUser) && Objects.equals(clientUser, that.clientUser) && Objects.equals(product, that.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, businessUser, clientUser, product);
    }


}
