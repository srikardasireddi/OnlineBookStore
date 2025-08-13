package com.onlinebookstore.bookservice.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BookTest {

    @Test
    void testBookGettersAndSetters() {
        Book book = new Book();
        book.setId(1L);
        book.setTitle("Spring Boot in Action");
        book.setAuthor("Craig Walls");
        book.setPrice(29.99);

        assertEquals(1L, book.getId());
        assertEquals("Spring Boot in Action", book.getTitle());
        assertEquals("Craig Walls", book.getAuthor());
        assertEquals(29.99, book.getPrice());
    }
}
