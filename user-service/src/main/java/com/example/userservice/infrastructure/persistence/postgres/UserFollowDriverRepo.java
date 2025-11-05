package com.example.userservice.infrastructure.persistence.postgres;

import com.example.userservice.infrastructure.persistence.entity.UserFollowEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserFollowDriverRepo extends JpaRepository<UserFollowEntity, UUID>{
    Optional<UserFollowEntity> findByFollowedIdAndFollowerId(UUID followedId, UUID followerId);

    boolean existsByFollowedIdAndFollowerId(UUID followedId, UUID followerId);
}
