package com.stock.seata.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.stock.seata.entity.StockTb;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author CH00SE 1
 * @since 2022-09-19
 */
public interface IStockTbService extends IService<StockTb> {

    /**
     * 扣减库存
     *
     * @param productId
     */
    void reduct(Integer productId);

}
