package com.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.concurrent.TimeUnit;

/**
 * @author CHOOSE1
 * @date 2022-09-15 09:05:35
 */
@SpringBootApplication
public class ConfigApplication {
    public static void main(String[] args) throws InterruptedException {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(ConfigApplication.class, args);
        while (true) {
            String property = applicationContext.getEnvironment().getProperty("user.name");
            String property1 = applicationContext.getEnvironment().getProperty("user.text");
            System.out.println(property + property1);
            TimeUnit.SECONDS.sleep(1);
        }
    }
}
