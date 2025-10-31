package com.example.userservice.infrastructure.persistence;

import com.example.userservice.domain.model.User;
import com.example.userservice.domain.persistance.UserRepository;
import com.example.userservice.infrastructure.persistence.entity.UserEntity;
import com.example.userservice.infrastructure.persistence.mapper.UserRepositoryMapper;
import com.example.userservice.infrastructure.persistence.postgres.UserDriverRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository {

    private final UserDriverRepo  userDriverRepo;
    private final UserRepositoryMapper mapper;

    @Override
    public User save(User user) {
        UserEntity entity = mapper.toEntity(user);
        UserEntity savedEntity = userDriverRepo.save(entity);
        return mapper.toModel(savedEntity);
    }

    @Override
    public User findById(UUID id) {
        return userDriverRepo.findById(id)
                .map(mapper::toModel)
                .orElse(null);
    }

    @Override
    public List<User> findAllUsers() {
        return userDriverRepo.findAll().stream()
                .map(mapper::toModel)
                .toList();
    }

    @Override
    public boolean existByEmail(String email) {
        return userDriverRepo.existsByEmail(email);
    }

    @Override
    public boolean existByUsername(String username) {
        return userDriverRepo.existsByUsername(username);
    }
}
