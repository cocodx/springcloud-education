package com.education.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @author 正能量导师
 * @version 1.0
 * @description 启动类
 * @date 24/1/2022 上午7:25 openFeign
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class Order80Application {

    public static void main(String[] args) {
        SpringApplication.run(Order80Application.class,args);
    }
}
