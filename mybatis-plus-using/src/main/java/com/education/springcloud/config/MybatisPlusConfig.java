package com.education.springcloud.config;

import com.baomidou.mybatisplus.extension.plugins.OptimisticLockerInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author 正能量导师
 * @version 1.0
 * @description 添加乐观锁的插件
 * @date 24/2/2022 上午1:59
 */
@EnableTransactionManagement
@Configuration
@MapperScan(basePackages = {"com.education.springcloud.mapper"})
public class MybatisPlusConfig {

    @Bean
    public OptimisticLockerInterceptor optimisticLockerInterceptor(){
        return new OptimisticLockerInterceptor();
    }
}
