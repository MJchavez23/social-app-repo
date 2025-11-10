package com.example.userservice.web.mapper;

import com.example.userservice.domain.model.User;
import com.example.userservice.web.dto.RequestDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class WebMapper {

    private final ModelMapper modelMapper = new ModelMapper();

    public User toModel(RequestDto requestDto) {
        return modelMapper.map(requestDto, User.class);
    }

}
