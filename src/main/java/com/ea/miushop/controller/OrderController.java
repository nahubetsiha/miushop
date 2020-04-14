package com.ea.miushop.controller;

import com.ea.miushop.domain.Order;
import com.ea.miushop.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    OrderService orderService;

    @GetMapping(value = "all")
    public List<Order> getAllOrders(){
        return orderService.getAllOrders();
    }

    @GetMapping(value = "{orderId}")
    public Order getOrderById(@PathVariable Long orderId){
        return orderService.getOrder(orderId);
    }

    @PostMapping(value = "new-order", produces = MediaType.APPLICATION_PROBLEM_JSON_VALUE)
    public void makeOrder(Order order){
        orderService.makeOrder(order);
    }

}
