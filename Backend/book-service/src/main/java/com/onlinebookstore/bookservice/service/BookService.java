package com.onlinebookstore.bookservice.service;

import com.onlinebookstore.bookservice.model.Book;
import java.util.List;

public interface BookService {
    Book getBookById(Long id);

    // Add this method
    List<Book> getAllBooks();
}
