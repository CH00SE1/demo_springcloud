package com.stock.seata;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author CHOOSE1
 * @date 2022-09-19 10:34:38
 */
@SpringBootApplication
@EnableTransactionManagement
@EnableFeignClients
public class AlibabaStockSeataApplication {

    public static void main(String[] args) {
        SpringApplication.run(AlibabaStockSeataApplication.class, args);
    }

}
