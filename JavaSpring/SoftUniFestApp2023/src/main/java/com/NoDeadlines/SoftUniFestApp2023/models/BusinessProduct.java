package com.NoDeadlines.SoftUniFestApp2023.models;



import jakarta.persistence.*;

@Entity
@Table(name = "business_product")
public class BusinessProduct {

    @Id
    @Column(name = "id") // Assuming you have an 'id' column in the 'business_product' table that wasn't shown in the diagram.
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "business_user_id")
    private BusinessUser businessUser;

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public BusinessUser getBusinessUser() {
        return businessUser;
    }

    public void setBusinessUser(BusinessUser businessUser) {
        this.businessUser = businessUser;
    }
}