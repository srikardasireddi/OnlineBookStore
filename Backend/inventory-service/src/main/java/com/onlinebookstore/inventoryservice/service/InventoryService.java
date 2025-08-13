package com.onlinebookstore.inventoryservice.service;

import com.onlinebookstore.inventoryservice.model.Inventory;
import java.util.List;

public interface InventoryService {
    void reduceStock(Long bookId, int quantity);
    List<Inventory> getAllInventory();
    Inventory addInventory(Inventory inventory);
    Inventory getInventoryByBookId(Long bookId);
    Inventory getInventoryById(Long id);

}
