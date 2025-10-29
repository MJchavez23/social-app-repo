package com.example.userservice.infrastructure.persistence.mapper;

import com.example.userservice.domain.model.User;
import com.example.userservice.infrastructure.persistence.entity.UserEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class PersistenceMapper {

    private final ModelMapper modelMapper =  new ModelMapper();


    public UserEntity toEntity(User user) {
        return modelMapper.map(user, UserEntity.class);
    }

    public User toModel(UserEntity userEntity) {
        return modelMapper.map(userEntity, User.class);
    }
}
