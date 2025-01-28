package com.mindhub.producer_rabbitmq.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/test")
public class AppController {

    private static final Logger log = LoggerFactory.getLogger(AppController.class);
    @Autowired
    private AmqpTemplate amqpTemplate;

    @GetMapping
    public ResponseEntity<String> getMessage(@RequestParam String message){
        try {
            amqpTemplate.convertAndSend("testingExchange", "routing.key", message);
            log.info("Se envio el mensaje");
        }catch (AmqpException amqpException){
            log.warn(amqpException.getMessage());
        }
        return ResponseEntity.ok("Message received");
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> getMessage(@PathVariable Long id){
        amqpTemplate.convertAndSend("testingExchange", "routing.key2", id);
        return ResponseEntity.ok("Id received");
    }


}
