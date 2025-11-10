package com.example.userservice.web.dto;


import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
public class RequestDto {
    @NotBlank(message = "Username can not be blank")
    private String username;

    @NotBlank(message = "Email can not be blank")
    private String email;

    @Length(max = 100, message = "Max of 100 characters for bio")
    private String bio;
}
