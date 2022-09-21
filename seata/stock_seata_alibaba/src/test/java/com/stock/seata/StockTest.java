package com.stock.seata;

import com.stock.seata.entity.StockTb;
import com.stock.seata.service.IStockTbService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author CHOOSE1
 * @date 2022-09-19 11:41:50
 */
@SpringBootTest
public class StockTest {


    @Autowired
    IStockTbService stockTbService;

    @Test
    void insert() {
        StockTb stockTb = new StockTb();
        stockTb.setProductId(9);
        stockTb.setCount(100);
        stockTbService.save(stockTb);
    }
}
