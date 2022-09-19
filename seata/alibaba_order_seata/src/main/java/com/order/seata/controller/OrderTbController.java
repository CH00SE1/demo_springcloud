package com.order.seata.controller;

import com.order.seata.entity.OrderTb;
import com.order.seata.service.IOrderTbService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
@RequestMapping("/order")
public class OrderTbController {

    final IOrderTbService orderTbService;

    public OrderTbController(IOrderTbService orderTbService) {
        this.orderTbService = orderTbService;
    }


    /**
     * 新增订单 数据保存订单信息
     *
     * @return
     */
    @GetMapping("/add")
    public String add() {
        OrderTb orderTb = new OrderTb();
        orderTb.setProductId(9);
        orderTb.setStatus(0);
        orderTb.setTotalAmount(100);
        orderTbService.create(orderTb);
        return "下单成功";
    }

}
