package com.NoDeadlines.SoftUniFestApp2023.repositories.contratcts;

import com.NoDeadlines.SoftUniFestApp2023.models.Product;

import java.util.List;

public interface ProductRepository {

    public List<Product> getProducts(int amount);
}
