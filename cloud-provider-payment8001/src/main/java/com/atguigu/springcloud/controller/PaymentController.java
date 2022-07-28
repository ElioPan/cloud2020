package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author
 * @create 2022-07-26-23:26
 */
@RestController
@Slf4j
public class PaymentController {
    @Resource
    private DiscoveryClient discoveryClient;
    @Value("${server.port}")
    private String serverPort;
    @Resource
    private PaymentService paymentService;
    @PostMapping("/payment/create")
    public CommonResult createPayment(@RequestBody Payment payment){
        int result = paymentService.createPayment(payment);
        log.info("添加结果是=========" + result);
        if(result > 0){
            return new CommonResult(200,"添加成功",result);
        }else {
            return new CommonResult(444,"添加失败",null);
        }
    }
    @GetMapping("/payment/query/{id}")
    public CommonResult queryPaymentById(@PathVariable("id") long id){
        Payment payment = paymentService.queryPaymentById(id);
        log.info("查询结果是=======" + payment + "addition");
        if(payment != null){
            return new CommonResult(200,"github-查询成功,端口号是" + serverPort,payment);
        }else {
            return new CommonResult(444,"master-查询失败-git-test-hot-fix", null);
        }
    }
    @GetMapping("/payment/discovery")
    public Object discovery(){
        List<String> services = discoveryClient.getServices();
        for(String service : services){
            log.info(service);
        }
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for(ServiceInstance instance : instances){
            log.info(instance.getInstanceId() +"\t"
                    +instance.getHost() + "\t"
                    +instance.getPort() + "\t"
                    +instance.getUri());
        }
        return this.discoveryClient;
    }
}
