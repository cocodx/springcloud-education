package com.education.springcloud.service.impl;

import cn.hutool.core.util.IdUtil;
import com.education.springcloud.dao.PaymentDao;
import com.education.springcloud.entity.Payment;
import com.education.springcloud.service.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @author 正能量导师
 * @version 1.0
 * @description
 * @date 24/1/2022 上午6:44
 */
@Service
public class PaymentServiceImpl implements PaymentService
{

//    @Autowired spring提供
//    @Resource jdk提供
    @Resource
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }

    @Override
    public String paymentInfo_OK(Integer id) {
        return "线程： "+Thread.currentThread().getName()+" paymentInfo_OK,id:"+id+"\t"+"哈哈哈";
    }

    //超时降级演示
    @HystrixCommand(fallbackMethod = "payment_TimeoutHandler",commandProperties = {
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value="5000") //5秒钟以内就是正常的业务逻辑
    })
    @Override
    public String payment_Timeout(Integer id) {
        int timeNumber = 6;

        try {
            TimeUnit.SECONDS.sleep(timeNumber);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程： "+Thread.currentThread().getName()+" paymentInfo_OK,id:"+id+"\t"+"哈哈哈"+"耗时（秒）"+timeNumber;
    }

    //兜底方法，上面方法出问题,我来处理，返回一个出错信息
    public String payment_TimeoutHandler(Integer id) {
        return "线程池："+Thread.currentThread().getName()+" payment_TimeoutHandler,系统繁忙,请稍后再试\t o(╥﹏╥)o ";
    }

    //服务熔断
    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),  //是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),   //当在配置时间窗口（10s）内达到此数量的失败后，打开断路，默认20个
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"),  //断路多久以后开始尝试是否恢复，默认5s
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60"), //出错百分比阈值，当达到此阈值后，开始短路。默认50%
    })
    public String paymentCircuitBreaker(Integer id){
        if (id<0){
            throw new RuntimeException("******** id 不能负数");
        }
        String serialNumber = IdUtil.simpleUUID();

        return Thread.currentThread().getName()+"\t"+"调用成功，流水号："+serialNumber;
    }

    public String paymentCircuitBreaker_fallback(@PathVariable("id") Integer id){
        return "id 不能负数，请稍候再试,(┬＿┬)/~~     id: " +id;
    }

    public int cuttingRope(int n) {
        if (n<=3){
            return n-1;
        }
        int a = n/3;
        int b = n%3;
        if (b==0){
            return (int) Math.pow(3,a);
        }
        if (b==1){
            return (int) (Math.pow(3,a-1)*4);
        }
        return (int) (Math.pow(3,a)*2);
    }

}
