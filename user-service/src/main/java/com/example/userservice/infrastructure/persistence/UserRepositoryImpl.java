package com.example.userservice.infrastructure.persistence;

import com.example.userservice.domain.model.User;
import com.example.userservice.domain.persistance.UserRepository;
import com.example.userservice.infrastructure.persistence.entity.UserEntity;
import com.example.userservice.infrastructure.persistence.mapper.PersistenceMapper;
import com.example.userservice.infrastructure.persistence.postgres.UserDriverRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository {

    private final UserDriverRepo  userDriverRepo;
    private final PersistenceMapper mapper;

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
}
