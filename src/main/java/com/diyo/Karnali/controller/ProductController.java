package com.diyo.Karnali.controller;

import com.diyo.Karnali.entity.Order;
import com.diyo.Karnali.entity.Product;
import com.diyo.Karnali.entity.User;
import com.diyo.Karnali.repository.ProductRepository;
import com.diyo.Karnali.repository.UserRepository;
import com.diyo.Karnali.serviceImpl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductServiceImpl productService;

      @PostMapping("/save")
        public Product saveProduct(@RequestBody Product product){
            return productService.saveProduct(product);}
     @GetMapping("/hello")
        public ResponseEntity<String> createProduct(){
            return  new ResponseEntity<>("hello", HttpStatus.OK);
          }
    @GetMapping("/all")
    public List<Product> getAllProducts(@PathVariable Product product){
        return productService.getAllProducts(product);
    }
}
