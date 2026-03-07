package com.sai.notification.service;

import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    public void sendNotification(String orderId) {

        System.out.println("Sending notification for order: " + orderId);

        // simulate email / sms sending

        System.out.println("Notification sent successfully for order: " + orderId);
    }
}