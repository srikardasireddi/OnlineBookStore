package com.onlinebookstore.inventoryservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Column;

@Entity
public class Inventory {

	  @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)  // or AUTO, depending on your DB setup
	    private Long id;

    @Column(nullable = false)
    private Long bookId;

    @Column(nullable = false)
    private int stock;
    
    private int quantity; 

    // Constructors (default and parameterized)
    public Inventory() {
    }

    public Inventory(Long id, Long bookId, int stock) {
        this.id = id;
        this.bookId = bookId;
        this.stock = stock;
    }

    // Getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
