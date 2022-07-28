package com.atguigu.springcloud.dao;

import com.atguigu.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author
 * @create 2022-07-26-22:54
 */
@Mapper
public interface PaymentDao {
    int createPayment(Payment payment);
    public Payment queryPaymentById(@Param("id") long id);
}
