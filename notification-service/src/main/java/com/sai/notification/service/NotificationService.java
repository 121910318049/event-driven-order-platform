package com.sai.notification.service;

import com.sai.notification.Model.Order;
import com.sai.notification.Repository.EmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    @Autowired
    private EmailRepository emailRepository;

    public void sendNotification(String orderId) {


        System.out.println("Sending notification for order: " + orderId);

        // simulate email / sms sending

        System.out.println("Notification sent successfully for order: " + orderId);
    }

    public String getNotificationStatus(String orderId) {
        System.out.println("Getting notification for order: " + orderId);
        Order order = emailRepository.findByOrderId(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found"));

        return order.getNotifyStatus();
    }

}