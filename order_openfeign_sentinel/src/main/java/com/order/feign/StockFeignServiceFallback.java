package com.order.feign;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @author CHOOSE1
 * @date 2022-09-16 09:19:53
 */
@Component
public class StockFeignServiceFallback implements StockFeignService{
    @Override
    public String reduct() {
        return "降级";
    }
}
