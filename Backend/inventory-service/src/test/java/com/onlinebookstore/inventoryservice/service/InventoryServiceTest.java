package com.onlinebookstore.inventoryservice.service;

import com.onlinebookstore.inventoryservice.exception.InventoryNotFoundException;
import com.onlinebookstore.inventoryservice.model.Inventory;
import com.onlinebookstore.inventoryservice.repository.InventoryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class InventoryServiceTest {

    @Mock
    private InventoryRepository inventoryRepository;

    @InjectMocks
    private InventoryService inventoryService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getInventoryById_found() {
        Inventory inventory = new Inventory(1L, 101L, 50);
        when(inventoryRepository.findById(1L)).thenReturn(Optional.of(inventory));

        Inventory result = inventoryService.getInventoryById(1L);

        assertNotNull(result);
        assertEquals(101L, result.getBookId());
        assertEquals(50, result.getStock());
    }

    @Test
    void getInventoryById_notFound() {
        when(inventoryRepository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(InventoryNotFoundException.class, () -> inventoryService.getInventoryById(1L));
    }
}
