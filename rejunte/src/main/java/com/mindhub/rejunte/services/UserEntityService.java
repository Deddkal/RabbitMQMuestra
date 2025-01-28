package com.mindhub.rejunte.services;

import com.mindhub.rejunte.dtos.UserEntityDTO;
import com.mindhub.rejunte.models.UserEntity;

public interface UserEntityService {

    UserEntity createUser(UserEntityDTO userEntityDTO);

    UserEntityDTO convertToDTO(UserEntity userEntity);

}
