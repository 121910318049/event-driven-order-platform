package com.sai.notification.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.sai.notification.service.NotificationService;

@Service
public class NotificationConsumer {

    private final NotificationService notificationService;

    public NotificationConsumer(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @KafkaListener(topics = "inventory-updated", groupId = "notification-group")
    public void consume(String orderId) {

        System.out.println("Inventory updated for order: " + orderId);

        notificationService.sendNotification(orderId);
    }
}