package com.onlinebookstore.bookservice.repository;

import com.onlinebookstore.bookservice.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
