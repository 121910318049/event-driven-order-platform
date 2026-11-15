package com.sai.notification.controller;

import com.sai.notification.service.NotificationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/notification")
public class Notifycontroller {


    private final NotificationService notificationService;
    public Notifycontroller(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @GetMapping("/status")
    public ResponseEntity<String> getNotificationStatus(@RequestParam  String orderId) {
        System.out.println("Getting notification for order: " + orderId);
        return ResponseEntity.ok(notificationService.getNotificationStatus(orderId));
    }

    @GetMapping("/test")
    public String test() {
        return "Notification service is working";
    }
}
