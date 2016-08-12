package com.wangkai.rabbitmq.producer;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitMessagingTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;

/**
 * rabbitmq生产者配置
 * Created by admin on 16/8/12.
 */
@Configuration
public class RabbitmqConfig {

    @Bean
    ConnectionFactory connectionFactory(){
        //
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
        connectionFactory.setAddresses("127.0.0.1:5672");
        connectionFactory.setUsername("guest");
        connectionFactory.setPassword("guest");
        connectionFactory.setVirtualHost("/");
        return connectionFactory;
    }

    @Bean
    RabbitAdmin rabbitAdmin(ConnectionFactory connectionFactory) {
        return new RabbitAdmin(connectionFactory);
    }

    @Bean
    Queue queueFoo(RabbitAdmin rabbitAdmin) {
        //持久化
        Queue queue = new Queue("queue.foo", true);
        rabbitAdmin.declareQueue(queue);
        return queue;
    }

    @Bean
    Queue queueBar(RabbitAdmin rabbitAdmin) {
        //持久化
        Queue queue = new Queue("queue.bar", true);
        rabbitAdmin.declareQueue(queue);
        return queue;
    }

    @Bean
    TopicExchange exchange(RabbitAdmin rabbitAdmin) {
        TopicExchange topicExchange = new TopicExchange("exchange");
        rabbitAdmin.declareExchange(topicExchange);
        return topicExchange;
    }

    @Bean
    Binding bindingExchangeFoo(Queue queueFoo, TopicExchange exchange,RabbitAdmin rabbitAdmin) {
        Binding binding = BindingBuilder.bind(queueFoo).to(exchange).with("queue.foo");
        rabbitAdmin.declareBinding(binding);
        return binding;
    }

    @Bean
    Binding bindingExchangeBar(Queue queueBar, TopicExchange exchange,RabbitAdmin rabbitAdmin) {
        Binding binding = BindingBuilder.bind(queueBar).to(exchange).with("queue.bar");
        rabbitAdmin.declareBinding(binding);
        return binding;
    }

    /**
     * 生产者用
     * @return
     */
    @Bean
    public RabbitMessagingTemplate rabbitMessagingTemplate(RabbitTemplate rabbitTemplate) {
        RabbitMessagingTemplate rabbitMessagingTemplate = new RabbitMessagingTemplate();
        rabbitMessagingTemplate.setMessageConverter(jackson2Converter());
        rabbitMessagingTemplate.setRabbitTemplate(rabbitTemplate);
        return rabbitMessagingTemplate;
    }

    @Bean
    public MappingJackson2MessageConverter jackson2Converter() {
        MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
        return converter;
    }
}
