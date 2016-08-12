package com.wangkai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by admin on 16/8/1.
 */
@SpringBootApplication
@EnableEurekaServer
public class ServerApplication extends WebMvcConfigurerAdapter{

    /**
     * 程序入口
     */
    public static void main(String[] args) {
        SpringApplication.run(ServerApplication.class, args);
    }
}
