package com.order.seata.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.order.seata.api.StockService;
import com.order.seata.entity.OrderTb;
import com.order.seata.mapper.OrderTbMapper;
import com.order.seata.service.IOrderTbService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

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

    final StockService stockService;

    public OrderTbServiceImpl(StockService stockService) {
        this.stockService = stockService;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public OrderTb create(OrderTb orderTb) {
        // 插入订单是否成功
        save(orderTb);
        // 远程调用
        stockService.reduct(orderTb.getProductId());
        return orderTb;
    }

}
