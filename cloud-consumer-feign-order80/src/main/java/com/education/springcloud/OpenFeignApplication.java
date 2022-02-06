package com.education.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author 正能量导师
 * @version 1.0
 * @description
 * @date 6/2/2022 下午7:48
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class OpenFeignApplication {

    public static void main(String[] args) {
        SpringApplication.run(OpenFeignApplication.class,args);
    }
}
