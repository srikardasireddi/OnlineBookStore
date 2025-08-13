package com.onlinebookstore.orderservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "inventory-service")
public interface InventoryClient {

    @GetMapping("/inventory/{bookId}/stock")
    int getStock(@PathVariable("bookId") Long bookId);

    @PutMapping("/inventory/{bookId}/reduceStock")
    void reduceStock(@PathVariable("bookId") Long bookId, @RequestParam("quantity") int quantity);
}
