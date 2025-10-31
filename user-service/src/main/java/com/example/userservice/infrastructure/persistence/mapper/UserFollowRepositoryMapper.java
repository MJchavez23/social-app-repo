package com.example.userservice.infrastructure.persistence.mapper;

import com.example.userservice.domain.model.UserFollow;
import com.example.userservice.infrastructure.persistence.entity.UserFollowEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class UserFollowRepositoryMapper {

    private final ModelMapper modelMapper = new ModelMapper();

    public UserFollowEntity toEntity(UserFollow userFollow) {
        return modelMapper.map(userFollow, UserFollowEntity.class);
    }

    public UserFollow toModel(UserFollowEntity userFollowEntity) {
        return modelMapper.map(userFollowEntity, UserFollow.class);
    }

}
