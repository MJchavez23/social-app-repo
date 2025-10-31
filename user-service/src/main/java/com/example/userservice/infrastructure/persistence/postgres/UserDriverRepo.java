package com.example.userservice.infrastructure.persistence.postgres;

import com.example.userservice.domain.model.User;
import com.example.userservice.infrastructure.persistence.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserDriverRepo extends JpaRepository<UserEntity, UUID> {
    boolean existsByEmail(String email);
    boolean existsByUsername(String username);
}
