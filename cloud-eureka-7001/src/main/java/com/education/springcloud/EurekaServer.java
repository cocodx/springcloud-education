package com.education.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author 正能量导师
 * @version 1.0
 * @description 启动类
 * @date 25/1/2022 下午11:30
 */
@EnableEurekaServer//声明当前微服务是注册中心
@SpringBootApplication
public class EurekaServer {

    public static void main(String[] args) {
        SpringApplication.run(EurekaServer.class,args);
    }
}
