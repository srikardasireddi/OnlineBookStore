package com.onlinebookstore.orderservice.client;

import com.onlinebookstore.orderservice.dto.BookDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "book-service")
public interface BookClient {

    @GetMapping("/books/{bookId}")
    BookDto getBookById(@PathVariable("bookId") Long bookId);
}
