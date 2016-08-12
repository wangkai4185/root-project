package com.wangkai.controller;

import com.wangkai.rabbitmq.MessageBean;
import com.wangkai.rabbitmq.producer.RabbitmqProducer;
import com.wangkai.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

/**
 * Created by admin on 16/7/27.
 */
@RestController
@RequestMapping("/v1/consumer")
public class ConsumerController {
    @Autowired
    DemoService demoService;

    @Autowired
    RabbitmqProducer rabbitmqProducer;

    @RequestMapping(value = "/test",method = RequestMethod.GET)
    public String hello(){
        //
        String info = demoService.sayHello("wangkai");
        //
        MessageBean bean = new MessageBean();
        int i = new Random().nextInt(100);
        bean.setId(i);
        bean.setName("kai"+i);
        //发送消息
        rabbitmqProducer.sendA(bean);
        rabbitmqProducer.sendB(bean);
        //
        return info;
    }
}
