package com.sai.order.controller;

import com.sai.order.model.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<ApiResponse<Order>> createOrder(@RequestBody Order order){


        Order savedOrder = service.createOrder(order);

        ApiResponse<Order> response = new ApiResponse<>(
                true,
                "Order created successfully",
                savedOrder
        );

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(response);
    }



    @GetMapping("/test")
    public String test(){
        return "Order Service Running";
    }
}