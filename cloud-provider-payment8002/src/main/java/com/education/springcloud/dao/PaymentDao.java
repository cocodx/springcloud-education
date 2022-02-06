package com.education.springcloud.dao;

import com.education.springcloud.entity.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Component;

/**
 * @author 正能量导师
 * @version 1.0
 * @description payment dao接口
 * @date 24/1/2022 上午6:37
 */
//mybatis提供的，等价：@MapperScan
@Component
//@Mapper
//@MapperScan("com.education.springcloud.dao")
public interface PaymentDao {

    int create(Payment payment);
    Payment getPaymentById(@Param("id")Long id);
}
