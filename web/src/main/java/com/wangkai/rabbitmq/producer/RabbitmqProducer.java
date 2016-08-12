package com.wangkai.rabbitmq.producer;

import com.wangkai.rabbitmq.MessageBean;
import org.springframework.amqp.rabbit.core.RabbitMessagingTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * Created by admin on 16/8/12.
 */
@Component
public class RabbitmqProducer {

    @Autowired
    private RabbitMessagingTemplate rabbitTemplate;

    @Async
    public Object sendA(MessageBean messageBean){
        System.out.println("producerA: send "+messageBean);
        rabbitTemplate.convertAndSend("exchange","queue.foo",messageBean);
        //
        return "OK";
    }

    @Async
    public Object sendB(MessageBean messageBean){
        System.out.println("producerB: send "+messageBean);
        rabbitTemplate.convertAndSend("exchange","queue.bar",messageBean);
        //
        return "OK";
    }
}
