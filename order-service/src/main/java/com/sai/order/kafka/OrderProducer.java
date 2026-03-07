package com.sai.order.kafka;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class OrderProducer {

    private final KafkaTemplate<String,String> kafkaTemplate;

    public OrderProducer(KafkaTemplate<String,String> kafkaTemplate){
        this.kafkaTemplate = kafkaTemplate;
    }

    public void publishOrder(String orderId){

        kafkaTemplate.send("order-created",orderId);

        System.out.println("Published order event: " + orderId);
    }
}