package com.education.springcloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Hello world!
 *
 */
@EnableEurekaClient//声明当前微服务是注册中心
@SpringBootApplication
@MapperScan("com.education.springcloud.dao")
public class PaymentApplication8002
{
    public static void main( String[] args )
    {
        SpringApplication.run(PaymentApplication8002.class,args);
    }
}
