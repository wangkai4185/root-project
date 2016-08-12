package com.wangkai;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Application
 *
 * @author niyanshi
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.wangkai"})
@ImportResource({"classpath:spring-dubbo-producer.xml"})
public class Application extends WebMvcConfigurerAdapter {

    /**
     * 程序入口
     */
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
