package com.mindhub.rejunte.services.impl;

import com.mindhub.rejunte.dtos.UserEntityDTO;
import com.mindhub.rejunte.exceptions.InvalidValueException;
import com.mindhub.rejunte.models.UserEntity;
import com.mindhub.rejunte.services.AppService;
import com.mindhub.rejunte.services.UserEntityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

@Service
public class AppServiceImpl implements AppService {

    private static final Logger log = LoggerFactory.getLogger(AppServiceImpl.class);
    @Autowired
    private UserEntityService userEntityService;

    @Autowired
    private AmqpTemplate amqpTemplate;

    @Override
//    @Transactional(rollbackFor = InvalidValueException.class)
    @Transactional
    public UserEntityDTO register(UserEntityDTO userEntityDTO) throws InvalidValueException {
        try {
            validateEntries(userEntityDTO);
            UserEntity userEntity = userEntityService.createUser(userEntityDTO);
            UserEntityDTO response = userEntityService.convertToDTO(userEntity);
            amqpTemplate.convertAndSend("testingExchange", "routing.key3", userEntityDTO);
            return new UserEntityDTO(userEntity);
        } catch (InvalidValueException e) {
            log.warn(e.getMessage());
//            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            throw e;
        }
    }

    public void validateEntries(UserEntityDTO userEntityDTO) throws InvalidValueException {
        if (userEntityDTO.getEmail().isBlank()){
            throw new InvalidValueException("El mail no puede estar vacio");
        }
        if (userEntityDTO.getPassword().isBlank()){
            throw new InvalidValueException("la password no puede estar vacio");
        }
    }
}
