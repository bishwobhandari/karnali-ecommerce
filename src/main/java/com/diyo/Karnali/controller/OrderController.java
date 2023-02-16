package com.diyo.Karnali.controller;

import com.diyo.Karnali.entity.Order;
import com.diyo.Karnali.entity.Product;
import com.diyo.Karnali.entity.User;
import com.diyo.Karnali.repository.OrderRepository;
import com.diyo.Karnali.repository.ProductRepository;
import com.diyo.Karnali.repository.UserRepository;
import com.diyo.Karnali.serviceImpl.OrderServiceImpl;
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
    private OrderServiceImpl orderService;

    @PostMapping("/save")
    public Order saveOrder(@RequestBody Order order){
        return orderService.save(order);
    }

    @PostMapping("/create")

    public Order createOrder(@RequestBody Order order)
    {
        System.out.println("diptis changes");
        return orderService.createOrder(order);
    }

    @PostMapping("/all")
    public List<Order> saveAll(@RequestBody List<Order> orderList){
        return orderService.saveAll(orderList);
    }

    @GetMapping("/list")
    public List<Order> findAllOrders(){
        return orderService.getOrders();
    }

    @GetMapping("/{orderId}")
    public Order findOrderById(@PathVariable long id){
        return orderService.getOrderById(id);
    }

    @PutMapping("/update")
    public Order updateOrder(@RequestBody Order order){
        return orderService.updateOrder(order);
    }

    @DeleteMapping("/delete/{orderId}")
    public String deleteOrder(@PathVariable long id){
        return orderService.deleteOrder(id);
    }

    @GetMapping("/getuserdetailsbyid/{userId}")
    public List<Order> getUserOrderDetails(@PathVariable long id){
        return orderService.getUserOrderDetails(id);
    }
    //create an api for a user to get total discount he recieved upto now.
    @GetMapping("/gettotaldiscountbyuser/{userId}")
    public double getUserDiscountReceived(@PathVariable long id){
        return orderService.getUserDiscountReceived(id);
    }
}
