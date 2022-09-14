package com.order.controller;

import com.order.feign.StockFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author CHOOSE1
 * @date 2022-09-14 15:16:45
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    StockFeignService stockFeignService;

    @GetMapping("/add")
    public String add() {
        String msg = stockFeignService.add();
        System.out.println("下单成功" + " - " + msg);
        return msg;
    }

}
