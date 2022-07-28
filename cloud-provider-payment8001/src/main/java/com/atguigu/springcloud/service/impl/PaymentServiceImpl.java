package com.atguigu.springcloud.service.impl;

import com.atguigu.springcloud.dao.PaymentDao;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author
 * @create 2022-07-26-23:18
 */
@Service
public class PaymentServiceImpl implements PaymentService {
    @Resource
    private PaymentDao paymentDao;
    @Override
    public int createPayment(Payment payment) {

        return paymentDao.createPayment(payment);
    }

    @Override
    public Payment queryPaymentById(long id) {
        return paymentDao.queryPaymentById(id);
    }
}
