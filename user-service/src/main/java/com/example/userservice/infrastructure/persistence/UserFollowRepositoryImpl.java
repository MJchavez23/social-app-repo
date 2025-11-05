package com.example.userservice.infrastructure.persistence;

import com.example.userservice.domain.model.UserFollow;
import com.example.userservice.domain.persistance.UserFollowRepository;
import com.example.userservice.infrastructure.persistence.entity.UserFollowEntity;
import com.example.userservice.infrastructure.persistence.mapper.UserFollowRepositoryMapper;
import com.example.userservice.infrastructure.persistence.postgres.UserFollowDriverRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;


@Repository
@RequiredArgsConstructor
public class UserFollowRepositoryImpl implements UserFollowRepository {

    private final UserFollowDriverRepo userFollowDriverRepo;
    private final UserFollowRepositoryMapper mapper;


    @Override
    public UserFollow save(UserFollow userFollow) {
        UserFollowEntity entity = mapper.toEntity(userFollow);
        UserFollowEntity userFollowEntity = userFollowDriverRepo.save(entity);
        return mapper.toModel(userFollowEntity);
    }

    @Override
    public void delete(UserFollow userFollow) {
        UserFollowEntity entity = mapper.toEntity(userFollow);
        userFollowDriverRepo.delete(entity);
    }

    @Override
    public Optional<UserFollow> findByFollowedAndFollower(UUID followedId, UUID followerId) {
        return userFollowDriverRepo.findByFollowedIdAndFollowerId(followedId, followerId)
                .map(mapper::toModel);
    }

    @Override
    public boolean existsByFollowedAndFollowerId(UUID followedId, UUID followerId) {
        return userFollowDriverRepo.existsByFollowedIdAndFollowerId(followedId, followerId);
    }
}
