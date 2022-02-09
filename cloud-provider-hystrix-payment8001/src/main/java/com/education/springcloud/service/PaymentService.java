package com.education.springcloud.service;

import com.education.springcloud.entity.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @author 正能量导师
 * @version 1.0
 * @description payment service
 * @date 24/1/2022 上午6:43
 */
public interface PaymentService {

    int create(Payment payment);
    Payment getPaymentById(@Param("id")Long id);

    public String paymentInfo_OK(Integer id);
    public String payment_Timeout(Integer id);
}
