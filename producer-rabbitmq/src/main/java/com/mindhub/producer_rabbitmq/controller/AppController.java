package com.mindhub.producer_rabbitmq.controller;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/test")
public class AppController {

    @Autowired
    private AmqpTemplate amqpTemplate;

    @GetMapping
    public ResponseEntity<String> getMessage(@RequestParam String message){
        amqpTemplate.convertAndSend("testingExchange", "routing.key", message);
        return ResponseEntity.ok("Message received");
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> getMessage(@PathVariable Long id){
        amqpTemplate.convertAndSend("testingExchange", "routing.key2", id);
        return ResponseEntity.ok("Id received");
    }


}
