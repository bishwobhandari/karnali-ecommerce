package com.diyo.Karnali.controller;

import com.diyo.Karnali.entity.Order;
import com.diyo.Karnali.entity.Product;
import com.diyo.Karnali.entity.User;
import com.diyo.Karnali.repository.OrderRepository;
import com.diyo.Karnali.repository.ProductRepository;
import com.diyo.Karnali.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {


    @Autowired
    OrderRepository orderRepo;

    @Autowired
    UserRepository userRepository;

    @Autowired
    ProductRepository productRepository;

    @PostMapping("/create")
    public Order createOroder(@RequestBody Order order){
        System.out.println(order.toString());
        User user = userRepository.findById(order.getUser().getId()).get();
        if(user != null){
            order.setUser(user);
            Product product = productRepository.findById(order.getProduct().getId()).get();
            if(product != null){
                order.setProduct(product);
                DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ssZ");
                Date date = new Date();
                order.setOrderDate(date);
                return orderRepo.save(order);
            }
        }

    return order;

    }

    @GetMapping("/all")
    public List<Order> createOroder(){

        return orderRepo.findAll();
    }
}
