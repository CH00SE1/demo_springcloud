package com.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author CHOOSE1
 * @date 2022-09-14 15:26:41
 */
@SpringBootApplication
@EnableFeignClients
public class OrderOpenfeignSentinelApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrderOpenfeignSentinelApplication.class, args);
    }
}
