package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author
 * @create 2022-07-27-12:26
 */
@RestController
@Slf4j
public class OrderController {
    @Resource
    private RestTemplate restTemplate;
    public static final String PAYMENT_URL="http://CLOUD-PAYMENT-SERVICE";
    @PostMapping("/consumer/payment/create")
    public CommonResult<Payment> createPayment(Payment payment){
        return restTemplate.postForObject(PAYMENT_URL + "/payment/create",payment, CommonResult.class);
    }

    @GetMapping("/consumer/payment/query/{id}")
    public CommonResult<Payment> queryPaymentById(@PathVariable("id") long id){
        return  restTemplate.getForObject(PAYMENT_URL + "/payment/query/" + id,CommonResult.class);
    }
}
