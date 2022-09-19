package com.order.seata.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author CHOOSE1
 * @date 2022-09-19 14:59:11
 */
@FeignClient(value = "alibaba-stock-seata", path = "/stock")
public interface StockService {

    @PostMapping("/reduct")
    public String reduct(@RequestParam(value = "productId") Integer productId);

}
