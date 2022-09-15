package com.order.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.order.exception.MyBlockExceptionHandler;
import com.order.service.IUserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author CHOOSE1
 * @date 2022-09-14 15:16:45
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @Resource
    private IUserService userService;

    @GetMapping("/add")
    public String add() {
        return "下单成功";
    }

    @GetMapping("/get")
    public String get() {
        return "查询成功";
    }

    @GetMapping("/flow")
    @SentinelResource(value = "flow", blockHandlerClass = MyBlockExceptionHandler.class)
    public String flow() {
        return "flow";
    }

    @GetMapping("/flowThread")
    // @SentinelResource(value = "flowThread", blockHandlerClass = MyBlockExceptionHandler.class)
    public String flowThread() throws InterruptedException {
        // TimeUnit.SECONDS.sleep(3);
        return "flow";
    }

    @GetMapping("/test1")
    public Object test1() {
        return userService.getUser();
    }

    @GetMapping("/test2")
    public Object test2() {
        return userService.getUser();
    }

}
