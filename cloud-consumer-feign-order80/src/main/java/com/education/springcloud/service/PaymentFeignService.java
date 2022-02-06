package com.education.springcloud.service;

import com.education.springcloud.entity.CommonResult;
import com.education.springcloud.entity.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author 正能量导师
 * @version 1.0
 * @description 远程服务调用的接口
 * @date 6/2/2022 下午7:54
 */
@Component
@FeignClient("cloud-payment-service")//指定远程服务调用名称 cloud-payment-service CLOUD-PAYMENT-SERVICE
public interface PaymentFeignService {


    @GetMapping(value = "/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id);


//    @PostMapping(value = "/payment/create")
//    public CommonResult<Payment> createPayment(@RequestBody Payment payment);
}
