package com.example.userservice.domain.persistance;

import com.example.userservice.domain.model.User;

import java.util.List;

public interface UserRepository {
    User save(User user);
    User findById(Long id);
    List<User> findAllUsers();
}
