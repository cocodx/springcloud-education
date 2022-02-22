package com.education.springcloud.controller;

import com.education.springcloud.service.PaymentHystrixService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author 正能量导师
 * @version 1.0
 * @description
 * @date 23/2/2022 上午1:09
 */
@RestController
@Slf4j
public class OrderHystrixController {

    @Resource
    private PaymentHystrixService paymentHystrixService;

    @GetMapping("/consumer/payment/hystrix/ok")
    public String ok(@RequestParam("id")Integer id){
        String result = paymentHystrixService.ok(id);
        log.info("ok-result:{}",result);
        return result;
    }

    @GetMapping("/consumer/payment/hystrix/timeout")
    public String timeout(@RequestParam("id")Integer id){
        String result = paymentHystrixService.timeout(id);
        log.info("timeout-result:{}",result);
        return result;
    }


}
