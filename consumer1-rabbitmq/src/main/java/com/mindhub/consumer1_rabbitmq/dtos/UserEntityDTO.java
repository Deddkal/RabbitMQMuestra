package com.mindhub.consumer1_rabbitmq.dtos;

import java.util.UUID;

public class UserEntityDTO {

    private UUID id;

    private String email, password;

    public UserEntityDTO() {
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

    @Override
    public String toString() {
        return "UserEntityDTO{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
