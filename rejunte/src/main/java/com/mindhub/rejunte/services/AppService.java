package com.mindhub.rejunte.services;


import com.mindhub.rejunte.dtos.UserEntityDTO;
import com.mindhub.rejunte.exceptions.InvalidValueException;

public interface AppService {

    UserEntityDTO register(UserEntityDTO userEntityDTO) throws InvalidValueException;
}
