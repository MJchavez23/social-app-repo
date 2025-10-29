package com.example.userservice.domain.persistance;

import com.example.userservice.domain.model.UserFollow;

public interface UserFollowRepository {
    UserFollow save(UserFollow userFollow);
    void delete(UserFollow userFollow);
}
