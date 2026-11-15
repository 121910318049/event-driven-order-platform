package com.sai.order.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.sai.order.model.Order;
import com.sai.order.repository.HiberNateRepo;
import com.sai.order.kafka.OrderProducer;

@Service
public class OrderService {

    @Autowired
    private HiberNateRepo repository;

    @Autowired
    private OrderProducer producer;

    public Order createOrder(Order order) {

        order.setStatus("CREATED");
        order.setNotifyStatus("NOTSENT");

        Order saved = repository.saveOrder(order);

        producer.publishOrder(saved.getOrderId());

        return saved;
    }
}