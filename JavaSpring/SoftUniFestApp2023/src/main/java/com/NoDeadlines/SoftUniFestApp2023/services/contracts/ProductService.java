package com.NoDeadlines.SoftUniFestApp2023.services.contracts;

import com.NoDeadlines.SoftUniFestApp2023.models.Product;

import java.util.List;

public interface ProductService {


List<Product> getProducts(int amount);
}
