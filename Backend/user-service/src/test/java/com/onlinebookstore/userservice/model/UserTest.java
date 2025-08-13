package com.onlinebookstore.userservice.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    void testUserModel() {
        User user = new User();
        user.setId(1L);
        user.setName("John Doe");
        user.setEmail("john@example.com");
        user.setPassword("password123");

        assertEquals(1L, user.getId());
        assertEquals("John Doe", user.getName());
        assertEquals("john@example.com", user.getEmail());
        assertEquals("password123", user.getPassword());

        user.setName("Jane Doe");
        assertEquals("Jane Doe", user.getName());

        // Equality checks using field values
        User anotherUser = new User();
        anotherUser.setId(1L);
        anotherUser.setName("Jane Doe");
        anotherUser.setEmail("john@example.com");
        anotherUser.setPassword("password123");

        assertNotSame(user, anotherUser); // Different objects
        assertEquals(user.getId(), anotherUser.getId());
        assertEquals(user.getEmail(), anotherUser.getEmail());
    }
}
