package com.onlinebookstore.userservice.service;

import com.onlinebookstore.userservice.model.User;
import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    User createUser(User user);
    User getUserById(Long id);
}
