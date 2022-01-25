package com.education.springcloud.controller;

import com.education.springcloud.entity.CommonResult;
import com.education.springcloud.entity.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author 正能量导师
 * @version 1.0
 * @description
 * @date 24/1/2022 上午7:30
 */
@Slf4j
@RequestMapping("/payment")
@RestController
public class PaymentController {

//    public static final String PAYMENT_URL = "http://localhost:8001/payment/";

    public static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";

    @Resource
    private RestTemplate template;

    @PostMapping(value = "/create")
    public CommonResult<Payment> createPayment(@RequestBody Payment payment){
        return template.postForObject(PAYMENT_URL+"/payment/create",payment,CommonResult.class);
    }

    @GetMapping(value = "/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
        return template.getForObject(PAYMENT_URL+"/payment/get/"+id,CommonResult.class);
    }
}
