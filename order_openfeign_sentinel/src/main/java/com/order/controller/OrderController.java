package com.order.controller;

import com.order.feign.StockFeignService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author CHOOSE1
 * @date 2022-09-14 15:16:45
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @Resource
    StockFeignService stockFeignService;

    @GetMapping("/add")
    public String add() {
        String msg = stockFeignService.reduct();
        System.out.println("下单成功" + " - " + msg);
        return msg;
    }

}
