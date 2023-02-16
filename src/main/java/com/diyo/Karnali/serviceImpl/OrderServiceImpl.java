package com.diyo.Karnali.serviceImpl;

import com.diyo.Karnali.entity.Order;
import com.diyo.Karnali.entity.Product;
import com.diyo.Karnali.entity.User;
import com.diyo.Karnali.repository.OrderRepository;
import com.diyo.Karnali.repository.ProductRepository;
import com.diyo.Karnali.repository.UserRepository;
import com.diyo.Karnali.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ProductRepository productRepository;


    @Override
    public Order save(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public List<Order> saveAll(List<Order> orderList) {
        return orderRepository.saveAll(orderList);
    }
    @Override
    public List<Order> getOrders() {
        return orderRepository.findAll();
    }
    @Override
    public Order getOrderById(long orderId) {
        return orderRepository.findById(orderId).orElse(null);
    }
    @Override
    public Order updateOrder(Order order) {
        Order existingOrder = orderRepository.findById(order.getId()).orElse(null);
        existingOrder.setOrderDate(order.getOrderDate());
        existingOrder.setUser(order.getUser());
        return orderRepository.save(existingOrder);
    }
    @Override
    public String deleteOrder(long orderId) {
        orderRepository.deleteById(orderId);
        return "Order has been removed " + orderId ;
    }

    @Override
    public Order createOrder(Order order) {
        System.out.println(order.toString());
        User user = userRepository.findById(order.getUser().getId()).get();
        if (user != null) {
            order.setUser(user);
            Product product = productRepository.findById(order.getProduct().getId()).get();
            if (product != null) {
                double amount = product.getPrice() * order.getQty();
                //order.setDiscountAmt(Math.round((amount*100)/100.0))-5/100);
            }
            order.setProduct(product);
            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ssZ");
            Date date = new Date();
            order.setOrderDate(date);
            return orderRepository.save(order);
        }
        return order;
    }
    @Override
    public List<Order> getUserOrderDetails(long id) {
        return orderRepository.getUserOrderDetails(id);
    }

    @Override
    public double getUserDiscountReceived(long id) {
        return orderRepository.getUserDiscountReceived(id);
    }
}
