package com.example.userservice.domain.persistance;

import com.example.userservice.domain.model.UserFollow;

import java.util.Optional;
import java.util.UUID;

public interface UserFollowRepository {
    UserFollow save(UserFollow userFollow);
    void delete(UserFollow userFollow);
    Optional<UserFollow> findByFollowedAndFollower(UUID followedId, UUID followerId);
    boolean existsByFollowedAndFollowerId(UUID followedId, UUID followerId);
}
