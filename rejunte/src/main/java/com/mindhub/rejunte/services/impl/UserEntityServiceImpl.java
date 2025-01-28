package com.mindhub.rejunte.services.impl;

import com.mindhub.rejunte.dtos.UserEntityDTO;
import com.mindhub.rejunte.models.UserEntity;
import com.mindhub.rejunte.repositories.UserEntityRepository;
import com.mindhub.rejunte.services.UserEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserEntityServiceImpl implements UserEntityService {

    @Autowired
    private UserEntityRepository userEntityRepository;

    @Override
    public UserEntity createUser(UserEntityDTO userEntityDTO) {
        return userEntityRepository.save(new UserEntity(userEntityDTO.getEmail(), userEntityDTO.getPassword()));
    }

    @Override
    public UserEntityDTO convertToDTO(UserEntity userEntity) {
        return new UserEntityDTO(userEntity);
    }

}
