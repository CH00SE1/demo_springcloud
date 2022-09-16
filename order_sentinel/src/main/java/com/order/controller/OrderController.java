package com.order.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.order.exception.MyBlockExceptionHandler;
import com.order.service.IUserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

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
//    @SentinelResource(value = "flow", blockHandlerClass = MyBlockExceptionHandler.class)
    public String flow() {
        return "flow";
    }

    @GetMapping("/flowThread")
    // @SentinelResource(value = "flowThread", blockHandlerClass = MyBlockExceptionHandler.class)
    public String flowThread() throws InterruptedException {
        TimeUnit.SECONDS.sleep(2);
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

    @GetMapping("/err")
    public String err() {
        int a = 1 / 0;
        return "hello";
    }

    @GetMapping("/get/{id}")
    @SentinelResource(value = "getById", blockHandler = "HotBlockHandler")
    public String getById(@PathVariable("id") Integer id) {
        return "正常访问";
    }

    public String HotBlockHandler(@PathVariable("id") Integer id, BlockException ex) {
        return "热点异常处理";
    }

}
