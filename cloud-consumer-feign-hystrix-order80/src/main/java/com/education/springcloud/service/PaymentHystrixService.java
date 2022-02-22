package com.education.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author 正能量导师
 * @version 1.0
 * @description
 * @date 23/2/2022 上午1:10
 */
@Component
@FeignClient(value = "CLOUD-HYSTRIX-PAYMENT-SERVICE")
public interface PaymentHystrixService {

    @GetMapping("/hystrix/ok")
    public String ok(@RequestParam("id") Integer id);

    @GetMapping("/hystrix/timeout")
    public String timeout(@RequestParam("id") Integer id);
}
