package com.diyo.Karnali.service;

import com.diyo.Karnali.entity.Order;
import org.springframework.stereotype.Service;

import java.util.List;

public interface OrderService {
    public Order save(Order order);

    public List<Order> saveAll(List<Order> orderList);

    public List<Order> getOrders();

    public Order getOrderById(long id) ;

    public Order updateOrder(Order order) ;

    public String deleteOrder(long id) ;

    public Order createOrder(Order order) ;
    public List<Order> getUserOrderDetails(long id);
    public double getUserDiscountReceived(long id);

}
