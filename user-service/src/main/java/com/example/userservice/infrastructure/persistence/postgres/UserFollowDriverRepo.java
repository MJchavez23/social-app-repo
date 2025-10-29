package com.example.userservice.infrastructure.persistence.postgres;

import com.example.userservice.infrastructure.persistence.entity.UserFollowEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserFollowDriverRepo extends JpaRepository<UserFollowEntity, UUID>{
}
