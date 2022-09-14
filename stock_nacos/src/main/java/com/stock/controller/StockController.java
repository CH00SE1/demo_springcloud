package com.stock.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author CHOOSE1
 * @date 2022-09-14 15:21:13
 */
@RestController
@RequestMapping("/stock")
public class StockController {

    public static final String stockReduct = "扣减库存";

    @Value("${server.port}")
    public String port;

    @GetMapping("/reduct")
    public String add() {
        System.out.println(stockReduct);
        return stockReduct + port;
    }

}
