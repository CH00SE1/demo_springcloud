package com.order.seata.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author CHOOSE1
 * @date 2022-09-21 08:54:39
 */
@FeignClient(value = "stock-seata-alibaba", path = "/stock")
public interface StockService {

    /**
     * 远程调用reduct
     *
     * @param productId
     * @return
     */
    @PostMapping("/reduct")
    String reduct(@RequestParam(value = "productId") Integer productId);

}
