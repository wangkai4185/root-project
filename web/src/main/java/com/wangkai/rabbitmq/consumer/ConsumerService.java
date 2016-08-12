package com.wangkai.rabbitmq.consumer;

import com.wangkai.rabbitmq.MessageBean;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 消息监听，接收消息
 * Created by admin on 16/8/12.
 */
@Component
public class ConsumerService {

    @RabbitListener(queues = "queue.foo")
    public void receiveFooQueue(MessageBean foo) {
        System.out.println("Received Foo<" + foo + ">");
    }

    @RabbitListener(queues = "queue.bar")
    public void receiveBarQueue(MessageBean bar) {
        System.out.println("Received Bar<" + bar + ">");
    }
}
