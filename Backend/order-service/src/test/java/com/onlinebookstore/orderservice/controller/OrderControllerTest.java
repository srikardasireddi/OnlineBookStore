package com.onlinebookstore.orderservice.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.onlinebookstore.orderservice.dto.OrderRequest;
import com.onlinebookstore.orderservice.model.Order;
import com.onlinebookstore.orderservice.service.OrderService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(OrderController.class)
class OrderControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private OrderService orderService;

    @Autowired
    private ObjectMapper objectMapper;

    private Order order1;
    private Order order2;

    @BeforeEach
    void setUp() {
        order1 = new Order();
        order1.setId(1L);
        order1.setUserId(10L);
        order1.setBookId(100L);
        order1.setQuantity(2);
        order1.setTotalPrice(500.0);
        order1.setOrderDate(LocalDateTime.now());
        order1.setStatus("PLACED");

        order2 = new Order();
        order2.setId(2L);
        order2.setUserId(20L);
        order2.setBookId(200L);
        order2.setQuantity(1);
        order2.setTotalPrice(300.0);
        order2.setOrderDate(LocalDateTime.now());
        order2.setStatus("SHIPPED");
    }

    @Test
    void testGetAllOrders() throws Exception {
        List<Order> orders = Arrays.asList(order1, order2);
        Mockito.when(orderService.getAllOrders()).thenReturn(orders);

        mockMvc.perform(get("/orders"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(2))
                .andExpect(jsonPath("$[0].userId").value(10L));
    }

    @Test
    void testGetOrderById() throws Exception {
        Mockito.when(orderService.getOrderById(1L)).thenReturn(order1);

        mockMvc.perform(get("/orders/{id}", 1L))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.userId").value(10L))
                .andExpect(jsonPath("$.bookId").value(100L));
    }

    @Test
    void testPlaceOrder() throws Exception {
        OrderRequest request = new OrderRequest();
        request.setUserId(10L);
        request.setBookId(100L);
        request.setQuantity(2);

        Mockito.when(orderService.placeOrder(any(OrderRequest.class))).thenReturn(order1);

        mockMvc.perform(post("/orders")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.totalPrice").value(500.0));
    }

    @Test
    void testUpdateOrder() throws Exception {
        OrderRequest request = new OrderRequest();
        request.setUserId(20L);
        request.setBookId(200L);
        request.setQuantity(1);

        Mockito.when(orderService.updateOrder(eq(1L), any(OrderRequest.class))).thenReturn(order2);

        mockMvc.perform(put("/orders/{id}", 1L)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.bookId").value(200L));
    }

    @Test
    void testDeleteOrder() throws Exception {
        Mockito.doNothing().when(orderService).deleteOrder(1L);

        mockMvc.perform(delete("/orders/{id}", 1L))
                .andExpect(status().isNoContent());
    }
}
