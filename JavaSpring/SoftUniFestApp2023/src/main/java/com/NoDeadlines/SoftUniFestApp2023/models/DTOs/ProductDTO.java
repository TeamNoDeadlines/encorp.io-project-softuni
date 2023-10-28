package com.NoDeadlines.SoftUniFestApp2023.models.DTOs;

import java.util.Objects;

public class ProductDTO {
    private int id;
    private int price;
    private String productName;
    private String description;




    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProductDTO that)) return false;
        return id == that.id && price == that.price && Objects.equals(productName, that.productName) && Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, price, productName, description);
    }
}