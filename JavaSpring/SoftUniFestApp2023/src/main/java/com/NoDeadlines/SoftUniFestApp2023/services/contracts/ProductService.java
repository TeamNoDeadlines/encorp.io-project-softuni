package com.NoDeadlines.SoftUniFestApp2023.services.contracts;

import com.NoDeadlines.SoftUniFestApp2023.models.DTOs.ProductDTO;
import com.NoDeadlines.SoftUniFestApp2023.models.Product;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface ProductService {


List<Product> getProducts(int amount);

    public  void createProduct (Product product);
}
