package com.stock.seata.controller;

import com.stock.seata.service.IStockTbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author CH00SE 1
 * @since 2022-09-19
 */
@RestController
@RequestMapping("/stock")
public class StockTbController {

    @Autowired
    IStockTbService stockTbService;

    @PostMapping("/reduct")
    public String reduct(@RequestParam(value = "productId") Integer productId) {

        stockTbService.reduct(productId);

        return "扣减库存";

    }

}
