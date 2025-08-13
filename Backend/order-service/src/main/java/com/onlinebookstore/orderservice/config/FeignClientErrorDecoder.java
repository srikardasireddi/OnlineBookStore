package com.onlinebookstore.orderservice.config;

import com.onlinebookstore.orderservice.exception.BookNotFoundException;
import com.onlinebookstore.orderservice.exception.UserNotFoundException;
import feign.Response;
import feign.codec.ErrorDecoder;
import org.springframework.stereotype.Component;

@Component
public class FeignClientErrorDecoder implements ErrorDecoder {

    private final ErrorDecoder defaultErrorDecoder = new Default();

    @Override
    public Exception decode(String methodKey, Response response) {
        if (response.status() == 404) {
            if (methodKey.contains("BookClient#getBookById")) {
                return new BookNotFoundException(null);
            }
            if (methodKey.contains("UserClient#getUserById")) {
                return new UserNotFoundException(null);
            }
        }
        return defaultErrorDecoder.decode(methodKey, response);
    }
}
