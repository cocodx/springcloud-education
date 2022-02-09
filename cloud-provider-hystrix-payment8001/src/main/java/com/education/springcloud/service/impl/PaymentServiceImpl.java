package com.education.springcloud.service.impl;

import com.education.springcloud.dao.PaymentDao;
import com.education.springcloud.entity.Payment;
import com.education.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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

    @Override
    public String payment_Timeout(Integer id) {
        int timeNumber = 3;

        try {
            TimeUnit.SECONDS.sleep(timeNumber);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程： "+Thread.currentThread().getName()+" paymentInfo_OK,id:"+id+"\t"+"哈哈哈"+"耗时（秒）"+timeNumber;
    }
}
