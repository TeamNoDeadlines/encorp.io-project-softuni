package com.NoDeadlines.SoftUniFestApp2023.controllers;

import com.NoDeadlines.SoftUniFestApp2023.models.BusinessUser;
import com.NoDeadlines.SoftUniFestApp2023.models.Product;
import com.NoDeadlines.SoftUniFestApp2023.models.mapper.ModelMapper;
import com.NoDeadlines.SoftUniFestApp2023.services.contracts.ProductService;
import com.NoDeadlines.SoftUniFestApp2023.services.contracts.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductCntroller {
    private final ModelMapper mapper;


    private final ProductService service;
@Autowired
    public ProductCntroller(ModelMapper mapper, ProductService service) {
        this.mapper = mapper;
        this.service = service;
    }


    @GetMapping("/products/{amount}")
    public List<Product> getProductsByAmount(@PathVariable int amount) {
        return service.getProducts(amount);
    }
}
