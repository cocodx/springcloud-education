package com.education.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @author 正能量导师
 * @version 1.0
 * @description
 * @date 23/2/2022 下午8:48
 */
@Component
public class PaymentFallbackService implements PaymentHystrixService{
    @Override
    public String ok(Integer id) {
        return "-----PaymentFallbackService fall back-paymentInfo_OK , (┬＿┬)";
    }

    @Override
    public String timeout(Integer id) {
        return "-----PaymentFallbackService fall back-paymentInfo_TimeOut , (┬＿┬)";
    }
}
