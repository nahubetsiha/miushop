package com.ea.miushop.service.impl;

import com.ea.miushop.domain.Order;
import com.ea.miushop.repository.OrderRepository;
import com.ea.miushop.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Order getOrder(Long id) {
        return orderRepository.getOne(id);
    }

    @Override
    public void makeOrder(Order order) {

        orderRepository.save(order);
    }

    @Override
    public void processOrder(Order order) {

    }

    @Override
    public void buyOrder(Order order) {

    }

    @Override
    public void deliverOrder(Order order) {

    }
}
