package com.onlinebookstore.inventoryservice.exception;

public class InsufficientStockException extends RuntimeException {
    public InsufficientStockException(Long bookId) {
        super("Insufficient stock for book with id: " + bookId);
    }
}
