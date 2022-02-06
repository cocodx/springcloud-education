package com.education.springcloud.controller;

import com.education.springcloud.entity.CommonResult;
import com.education.springcloud.entity.Payment;
import com.education.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.TimeUnit;

/**
 * @author 正能量导师
 * @version 1.0
 * @description
 * @date 24/1/2022 上午6:46
 */
@Slf4j
@RestController
@RequestMapping(value = "/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    String port;

    @PostMapping(value = "/create")
    public CommonResult<Payment> createPayment(@RequestBody Payment payment){
        int result = paymentService.create(payment);
        log.debug("插入结果:"+result);
        if (result>0){
            return new CommonResult(200,"插入数据库成功",result);
        }else{
            return new CommonResult(500,"插入失败");
        }
    }

    @GetMapping(value = "/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
        log.debug("port:{}",port);
        Payment payment = paymentService.getPaymentById(id);
        log.debug("payment:{}",payment);
        return new CommonResult(200,"查询成功",payment);
    }

    @GetMapping(value = "/feign/timeout")
    public String paymentFeignTimeout(){
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }


}
