package com.onlinebookstore.inventoryservice.controller;

import com.onlinebookstore.inventoryservice.model.Inventory;
import com.onlinebookstore.inventoryservice.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/inventory")
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;

    @GetMapping("/{bookId}")
    public Inventory getInventoryByBookId(@PathVariable Long bookId) {
        return inventoryService.getInventoryByBookId(bookId);
    }
}
