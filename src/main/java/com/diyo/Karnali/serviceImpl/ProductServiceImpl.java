package com.diyo.Karnali.serviceImpl;

import com.diyo.Karnali.entity.Product;
import com.diyo.Karnali.repository.ProductRepository;
import com.diyo.Karnali.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public List<Product> getAllProducts(Product product) {
        return productRepository.findAll();
    }

    @Override
    public ResponseEntity<String> createProduct() {
        Product product =  productRepository.save(new Product());
        return  new ResponseEntity<>("new product", HttpStatus.CREATED);
    }
}

