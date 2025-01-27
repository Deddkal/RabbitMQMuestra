package com.mindhub.consumer1_rabbitmq.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.support.ListenerExecutionFailedException;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

//    @Bean
//    public Queue queue() {
//        return new Queue("testingQueue1", false);
//    }
//    @Bean
//    public Queue queue2() {
//        return new Queue("testingQueue2", false);
//    }
//
//    @Bean
//    public TopicExchange exchange() {
//        return new TopicExchange("testingExchange");
//    }
//
//    @Bean
//    public Binding bindingQueue(Queue queue, TopicExchange exchange) {
//        return BindingBuilder.bind(queue).to(exchange).with("routing.key");
//    }
//
//    @Bean
//    public Binding bindingQueue2(Queue queue2, TopicExchange exchange) {
//        return BindingBuilder.bind(queue2).to(exchange).with("routing.key2");
//    }
//
//    @Bean
//    public AmqpTemplate amqpTemplate(ConnectionFactory connectionFactory) {
//        return new RabbitTemplate(connectionFactory);
//    }

}
