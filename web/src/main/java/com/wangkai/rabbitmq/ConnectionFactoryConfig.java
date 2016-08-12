package com.wangkai.rabbitmq;

import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by admin on 16/8/12.
 */
@Configuration
public class ConnectionFactoryConfig {

    @Bean
    ConnectionFactory connectionFactory(){
        //
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
        connectionFactory.setUsername("guest");
        connectionFactory.setPassword("guest");
        connectionFactory.setHost("192.168.20.47");
        connectionFactory.setPort(15672);
        connectionFactory.setVirtualHost("/");
        return connectionFactory;
    }
}
