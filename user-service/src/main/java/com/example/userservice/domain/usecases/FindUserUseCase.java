package com.example.userservice.domain.usecases;

import com.example.userservice.domain.model.User;

import java.util.List;

public interface FindUserUseCase {
    User findById(Long id);
    List<User> findAllUsers();
}
