package com.config.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author CHOOSE1
 * @date 2022-09-15 10:00:42
 */
@RestController
@RequestMapping("/config")
@RefreshScope // 动态读取
public class ConfigController {

    @Value("${user.name}")
    public String username;

    @GetMapping("/show")
    public String show() {
        return username;
    }

}
