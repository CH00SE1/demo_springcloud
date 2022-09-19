package com.order.seata;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 启动类
 * @author CHOOSE1
 * @date 2022-09-19 10:23:48
 */
@SpringBootApplication
@EnableTransactionManagement
@EnableFeignClients
public class AlibabaOrderSeataApplication {

    public static void main(String[] args) {
        SpringApplication.run(AlibabaOrderSeataApplication.class, args);
    }

}
