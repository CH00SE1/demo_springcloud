package com.order.seata;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author CHOOSE1
 * @date 2022-09-21 08:47:44
 */
@SpringBootApplication
@EnableFeignClients
public class OrderSeataAlibabaApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrderSeataAlibabaApplication.class, args);
    }
}
