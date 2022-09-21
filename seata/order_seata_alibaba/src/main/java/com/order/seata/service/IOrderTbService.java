package com.order.seata.service;

import com.order.seata.entity.OrderTb;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author CH00SE 1
 * @since 2022-09-19
 */
public interface IOrderTbService extends IService<OrderTb> {

    /**
     * 创建订单
     *
     * @param orderTb
     * @return
     */
    OrderTb create(OrderTb orderTb);

}
