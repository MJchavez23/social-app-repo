package com.example.userservice.infrastructure.persistance.postgres;

import com.example.userservice.infrastructure.persistance.entity.UserFollowEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserFollowDriverRepo extends JpaRepository<UserFollowEntity, UUID>{
}
