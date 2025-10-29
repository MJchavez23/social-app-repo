package com.example.userservice.infrastructure.persistence;

import com.example.userservice.domain.model.UserFollow;
import com.example.userservice.domain.persistance.UserFollowRepository;
import com.example.userservice.infrastructure.persistence.postgres.UserFollowDriverRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;


@Repository
@RequiredArgsConstructor
public class UserFollowRepositoryImpl implements UserFollowRepository {

    private final UserFollowDriverRepo userFollowDriverRepo;

    @Override
    public UserFollow save(UserFollow userFollow) {
        return null;
    }

    @Override
    public void delete(UserFollow userFollow) {

    }
}
