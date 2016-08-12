package com.wangkai.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by admin on 16/8/1.
 */
@RestController
@RequestMapping("/v1/test/")
public class TestController {

    @RequestMapping(value = "hello",method = RequestMethod.GET)
    public String testHello(@RequestParam(value = "name") String name){
        //
        String info = "hello,"+name;

        return info;
    }
}
