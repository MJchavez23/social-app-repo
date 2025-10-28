package com.example.userservice.infrastructure.persistance.postgres;

import com.example.userservice.infrastructure.persistance.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserDriverRepo extends JpaRepository<UserEntity, UUID> {
}
