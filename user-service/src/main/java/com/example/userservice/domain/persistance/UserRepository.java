package com.example.userservice.domain.persistance;

import com.example.userservice.domain.model.User;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserRepository {
    User save(User user);
    Optional<User> findById(UUID id);
    List<User> findAllUsers();
    boolean existByEmail(String email);
    boolean existByUsername(String username);
}
