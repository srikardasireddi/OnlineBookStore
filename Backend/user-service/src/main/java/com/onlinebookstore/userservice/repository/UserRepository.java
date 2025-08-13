package com.onlinebookstore.userservice.repository;

import com.onlinebookstore.userservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
