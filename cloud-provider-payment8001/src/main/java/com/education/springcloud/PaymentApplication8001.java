package com.education.springcloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@MapperScan("com.education.springcloud")
public class PaymentApplication8001
{
    public static void main( String[] args )
    {
        SpringApplication.run(PaymentApplication8001.class,args);
    }
}
