package com.example.userservice.infrastructure.persistence.postgres;

import com.example.userservice.infrastructure.persistence.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserDriverRepo extends JpaRepository<UserEntity, UUID> {
}
