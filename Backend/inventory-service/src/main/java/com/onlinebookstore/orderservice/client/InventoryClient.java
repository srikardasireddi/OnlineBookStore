package com.onlinebookstore.orderservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

// Talks to inventory-service
@FeignClient(name = "inventory-service")
public interface InventoryClient {

    @PostMapping("/inventory/reduce")
    void reduceStock(@RequestParam("bookId") Long bookId,
                     @RequestParam("quantity") int quantity);
}
