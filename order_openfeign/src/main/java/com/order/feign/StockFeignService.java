package com.order.feign;

import com.order.config.FeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * name 指定rest调用所对应的服务名
 * path 指定调用rest接口所在的controller指定的@RequestMapping
 * 添加feign接口和方法
 *
 * @author CHOOSE1
 * @date 2022-09-14 20:44:40
 */
@FeignClient(name = "stock-service", path = "/stock/", configuration = FeignConfig.class)
public interface StockFeignService {

    @GetMapping("/reduct")
    String add();

}
