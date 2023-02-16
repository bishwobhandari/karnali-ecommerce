package com.diyo.Karnali.controller;

import com.diyo.Karnali.entity.Order;
import com.diyo.Karnali.entity.Product;
import com.diyo.Karnali.entity.User;
import com.diyo.Karnali.repository.ProductRepository;
import com.diyo.Karnali.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductRepository productRepository;

    @PostMapping("/create")
    public Product createProduct(@RequestBody Product product){
        return  productRepository.save(product);
    }

    @GetMapping("/all")
    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }
}
