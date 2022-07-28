package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entities.Payment;

/**
 * @author
 * @create 2022-07-26-23:17
 */
public interface PaymentService {
    public int createPayment(Payment payment);
    public Payment queryPaymentById(long id);
}
