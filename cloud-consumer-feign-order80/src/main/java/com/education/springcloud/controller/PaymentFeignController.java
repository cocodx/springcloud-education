package com.education.springcloud.controller;

import com.education.springcloud.entity.CommonResult;
import com.education.springcloud.entity.Payment;
import com.education.springcloud.service.PaymentFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 正能量导师
 * @version 1.0
 * @description
 * @date 6/2/2022 下午8:00
 */
@RestController
public class PaymentFeignController {

    @Autowired
    private PaymentFeignService paymentFeignService;

    @GetMapping(value = "consumer/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
        return paymentFeignService.getPaymentById(id);
    }
}
