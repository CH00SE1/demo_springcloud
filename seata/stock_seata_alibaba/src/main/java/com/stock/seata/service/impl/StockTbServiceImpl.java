package com.stock.seata.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.stock.seata.entity.StockTb;
import com.stock.seata.mapper.StockTbMapper;
import com.stock.seata.service.IStockTbService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author CH00SE 1
 * @since 2022-09-19
 */
@Service
public class StockTbServiceImpl extends ServiceImpl<StockTbMapper, StockTb> implements IStockTbService {

    @Override
    public void reduct(Integer productId) {
        LambdaUpdateWrapper<StockTb> luw = new LambdaUpdateWrapper<StockTb>().eq(StockTb::getProductId, productId);
        StockTb stockTb = getOne(luw);
        update(new LambdaUpdateWrapper<StockTb>().eq(StockTb::getProductId, productId).set(StockTb::getCount, stockTb.getCount() - 1));
    }
}
