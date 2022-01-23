package com.education.springcloud.controller;

import com.education.springcloud.entity.CommonResult;
import com.education.springcloud.entity.Payment;
import com.education.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author 正能量导师
 * @version 1.0
 * @description
 * @date 24/1/2022 上午6:46
 */
@RestController(value = "/payment")
@Slf4j
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping(value = "/create")
    public CommonResult<Payment> createPayment(@RequestBody Payment payment){
        int result = paymentService.create(payment);
        log.debug("插入结果:"+result);
        if (result>0){
            return new CommonResult(200,"插入数据库成功",result);
        }else{
            return new CommonResult(200,"插入数据库成功");
        }
    }

    @GetMapping(value = "/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
        Payment payment = paymentService.getPaymentById(id);
        return new CommonResult(200,"插入数据库成功",payment);
    }


}
