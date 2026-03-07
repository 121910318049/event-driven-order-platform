package com.sai.inventory.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.sai.inventory.service.InventoryService;

@Service
public class InventoryConsumer {

    private final InventoryService inventoryService;

    public InventoryConsumer(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    @KafkaListener(topics = "payment-completed", groupId = "inventory-group")
    public void consume(String orderId) {

        System.out.println("Payment completed for order: " + orderId);

        inventoryService.updateInventory(orderId);
    }
}