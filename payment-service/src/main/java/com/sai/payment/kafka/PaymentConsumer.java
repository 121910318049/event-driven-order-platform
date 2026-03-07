package com.sai.payment.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.sai.payment.service.PaymentService;

@Service
public class PaymentConsumer {

    private final PaymentService paymentService;

    public PaymentConsumer(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @KafkaListener(topics = "order-created", groupId = "payment-group")
    public void consume(String orderId) {

        System.out.println("Received order event: " + orderId);

        paymentService.processPayment(orderId);
    }
}