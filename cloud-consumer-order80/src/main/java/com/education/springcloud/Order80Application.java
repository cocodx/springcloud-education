package com.education.springcloud;

import com.education.springcloud.config.httprule.MyHttpRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @author 正能量导师
 * @version 1.0
 * @description 启动类
 * @date 24/1/2022 上午7:25 openFeign
 */
@EnableEurekaClient//声明当前微服务是客户端
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@RibbonClient(name = "CLOUD-PAYMENT-SERVICE",configuration = MyHttpRule.class)//访问这个name的服务时，就采用class的规则
public class Order80Application {

    public static void main(String[] args) {
        SpringApplication.run(Order80Application.class,args);
    }
}
