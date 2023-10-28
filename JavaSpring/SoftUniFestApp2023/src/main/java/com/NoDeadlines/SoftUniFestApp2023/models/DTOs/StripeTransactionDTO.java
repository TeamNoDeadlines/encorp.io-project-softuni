package com.NoDeadlines.SoftUniFestApp2023.models.DTOs;

import java.util.Objects;

public class StripeTransactionDTO {
    private int id;
    private BusinessUserDTO businessUser;
    private ClientUserDTO clientUser;
    private ProductDTO product;
    private float paymentAmount;
    private String paymentStatus;
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

    public BusinessUserDTO getBusinessUser() {
        return businessUser;
    }

    public void setBusinessUser(BusinessUserDTO businessUser) {
        this.businessUser = businessUser;
    }

    public ClientUserDTO getClientUser() {
        return clientUser;
    }

    public void setClientUser(ClientUserDTO clientUser) {
        this.clientUser = clientUser;
    }

    public ProductDTO getProduct() {
        return product;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StripeTransactionDTO that)) return false;
        return getId() == that.getId() && Objects.equals(getBusinessUser(), that.getBusinessUser()) && Objects.equals(getClientUser(), that.getClientUser()) && Objects.equals(getProduct(), that.getProduct());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getBusinessUser(), getClientUser(), getProduct());
    }

    public void setProduct(ProductDTO product) {
        this.product = product;
    }
}

