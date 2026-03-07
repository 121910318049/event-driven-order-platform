package com.sai.inventory.service;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class InventoryService {
    private final KafkaTemplate<String, String> kafkaTemplate;

    public InventoryService(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void updateInventory(String orderId) {

        System.out.println("Updating inventory for order: " + orderId);

        System.out.println("Inventory updated successfully");
        kafkaTemplate.send("inventory-updated", orderId);
    }
}