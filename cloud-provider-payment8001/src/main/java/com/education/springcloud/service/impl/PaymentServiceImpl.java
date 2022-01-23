package com.education.springcloud.service.impl;

import com.education.springcloud.dao.PaymentDao;
import com.education.springcloud.entity.Payment;
import com.education.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

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
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
