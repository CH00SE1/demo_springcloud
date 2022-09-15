package com.stock.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

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
    public String add() throws InterruptedException {
        Thread.sleep(4000);
        Calendar calendar = Calendar.getInstance();
        Date time = calendar.getTime();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        System.out.println(stockReduct + " - " + simpleDateFormat.format(time));
        return stockReduct + port;
    }

}
