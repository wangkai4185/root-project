package com.wangkai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Created by admin on 16/8/1.
 */
@SpringBootApplication
@EnableEurekaClient
public class ClientApplication {

    /**
     * 程序入口
     */
    public static void main(String[] args) {
        SpringApplication.run(ClientApplication.class, args);
    }

}
