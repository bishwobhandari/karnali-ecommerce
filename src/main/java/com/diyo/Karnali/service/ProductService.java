package com.diyo.Karnali.service;

import com.diyo.Karnali.entity.Product;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProductService {
    public Product saveProduct(Product product);

    public List<Product> getAllProducts(Product product);

    public ResponseEntity<String> createProduct();
}
