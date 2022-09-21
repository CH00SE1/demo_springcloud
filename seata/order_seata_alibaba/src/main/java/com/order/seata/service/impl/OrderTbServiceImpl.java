package com.order.seata.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.order.seata.api.StockService;
import com.order.seata.entity.OrderTb;
import com.order.seata.mapper.OrderTbMapper;
import com.order.seata.service.IOrderTbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author CH00SE 1
 * @since 2022-09-19
 */
@Service
public class OrderTbServiceImpl extends ServiceImpl<OrderTbMapper, OrderTb> implements IOrderTbService {

    @Autowired
    StockService stockService;

    @Transactional
    @Override
    public OrderTb create(OrderTb orderTb) {
        // 插入订单是否成功
        save(orderTb);
        // openFeign 方式调用
        stockService.reduct(orderTb.getProductId());
        // 异常
        int a = 1 / 0;
        return orderTb;
    }

}
