package com.education.springcloud.config.httprule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 正能量导师
 * @version 1.0
 * @description
 * @date 26/1/2022 上午12:20
 */
@Configuration
public class MyHttpRule {

    @Bean
    public IRule myRule(){
        return new RandomRule();//定义为随机
    }
}
