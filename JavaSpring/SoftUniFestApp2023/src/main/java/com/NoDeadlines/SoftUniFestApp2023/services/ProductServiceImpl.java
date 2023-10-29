package com.NoDeadlines.SoftUniFestApp2023.services;

import com.NoDeadlines.SoftUniFestApp2023.models.Product;
import com.NoDeadlines.SoftUniFestApp2023.repositories.contratcts.ProductRepository;

import com.NoDeadlines.SoftUniFestApp2023.services.contracts.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {


    private final ProductRepository repository;

@Autowired
    public ProductServiceImpl(ProductRepository repository) {
        this.repository = repository;
    }


    @Override
    public List<Product> getProducts(int amount) {
        return repository.getProducts(amount);
    }

    @Override
    public void createProduct(Product product) {
        repository.createProduct(product);
    }


    @Override
    public List<Product> getProductsByBusinessUser(String businessUserName) {
        return repository.getProductsByBusinessUser(businessUserName);
    }
}
