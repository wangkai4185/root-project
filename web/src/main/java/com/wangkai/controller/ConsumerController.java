package com.wangkai.controller;

import com.wangkai.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by admin on 16/7/27.
 */
@RestController
@RequestMapping("/v1/consumer")
public class ConsumerController {
    @Autowired
    DemoService demoService;

    @RequestMapping(value = "/test",method = RequestMethod.GET)
    public String hello(){
        //
        String info = demoService.sayHello("wangkai");

        return info;
    }
}
