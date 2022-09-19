package com.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author CHOOSE1
 * @date 2022-09-14 15:16:45
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private RestTemplate restTemplate;

    public static final String ORDER_ADD = "下单成功";

    @GetMapping("/add")
    public String add() {
        System.out.println(ORDER_ADD);
        String msg = restTemplate.getForObject("http://localhost:8091/stock/reduct", String.class);
        System.out.println(msg);
        return ORDER_ADD + " - " + msg;
    }

}
