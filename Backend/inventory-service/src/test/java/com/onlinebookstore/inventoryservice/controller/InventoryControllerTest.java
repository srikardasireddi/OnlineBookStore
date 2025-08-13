package com.onlinebookstore.inventoryservice.controller;

import com.onlinebookstore.inventoryservice.model.Inventory;
import com.onlinebookstore.inventoryservice.service.InventoryService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(InventoryController.class)
class InventoryControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private InventoryService inventoryService;

    @Test
    void testGetInventoryByBookId() throws Exception {
        Inventory inventory = new Inventory();
        inventory.setId(1L);
        inventory.setBookId(200L);
        inventory.setStock(50);

        when(inventoryService.getInventoryByBookId(200L)).thenReturn(inventory);

        mockMvc.perform(get("/inventory/200")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.bookId").value(200))
                .andExpect(jsonPath("$.stock").value(50));
    }
}
