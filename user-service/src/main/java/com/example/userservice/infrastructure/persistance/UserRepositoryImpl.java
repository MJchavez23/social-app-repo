package com.example.userservice.infrastructure.persistance;

import com.example.userservice.domain.model.User;
import com.example.userservice.domain.persistance.UserRepository;

import java.util.List;

public class UserRepositoryImpl implements UserRepository {
    @Override
    public User save(User user) {
        return null;
    }

    @Override
    public User findById(Long id) {
        return null;
    }

    @Override
    public List<User> findAllUsers() {
        return List.of();
    }
}
