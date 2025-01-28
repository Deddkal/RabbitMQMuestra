package com.mindhub.rejunte.dtos;

import com.mindhub.rejunte.models.UserEntity;

import java.util.UUID;

public class UserEntityDTO {

    private UUID id;

    private String email, password;

    public UserEntityDTO() {
    }

    public UserEntityDTO(UserEntity userEntity) {
        id = userEntity.getId();
        email = userEntity.getEmail();
    }

    public UUID getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }


    public String getPassword() {
        return password;
    }
}
