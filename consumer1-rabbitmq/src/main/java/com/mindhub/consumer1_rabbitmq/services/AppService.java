package com.mindhub.consumer1_rabbitmq.services;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class AppService {


    @RabbitListener(queues = "testingQueue1")
    public void listenerQueue1(String message){
        System.out.println("Mensaje de testingQueue: " + message);
    }

    @RabbitListener(queues = "testingQueue2")
    public void listenerQueue2(Long id){
        System.out.println("Id en testingQueue2: " + id);
    }

}
