package com.sai.payment.service;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public PaymentService(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void processPayment(String orderId) {

        System.out.println("Processing payment for order: " + orderId);

        // simulate payment success

        System.out.println("Payment completed");

        kafkaTemplate.send("payment-completed", orderId);
    }
}