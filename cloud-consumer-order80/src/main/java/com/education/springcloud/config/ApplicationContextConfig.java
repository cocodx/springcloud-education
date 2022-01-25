package com.education.springcloud.config;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @author 正能量导师
 * @version 1.0
 * @description
 * @date 24/1/2022 上午7:29
 */
@SpringBootConfiguration
public class ApplicationContextConfig {

    @Bean
    @LoadBalanced//通过注册中心，获取服务列表，远程调用采用负载均衡（LB）默认轮训模式
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
