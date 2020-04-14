package com.ea.miushop.service;

import com.ea.miushop.domain.Order;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderService {
    List<Order> getAllOrders();
    Order getOrder(Long id);
    void makeOrder(Order order);
    void processOrder(Order order);
    void buyOrder(Order order);
    void deliverOrder(Order order);
}
