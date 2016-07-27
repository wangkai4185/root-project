package com.wangkai.service;

import org.springframework.stereotype.Service;

/**
 * Created by admin on 16/7/27.
 */
@Service
public class DemoServiceImpl implements DemoService {

    public String sayHello(String name) {
        //
        return "hello,"+name;
    }
}
