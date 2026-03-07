package com.sai.order.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import com.sai.order.model.Order;
import com.sai.order.service.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService service;

    @PostMapping
    public Order createOrder(@RequestBody Order order){

        return service.createOrder(order);
    }

    @GetMapping("/test")
    public String test(){
        return "Order Service Running";
    }
}