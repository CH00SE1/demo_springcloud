package com.order.exception;

import com.order.interceptor.CustomFeignInterceptor;
import feign.Logger;
import org.springframework.context.annotation.Bean;

/**
 * 加上@Configuration 全局有效 独立有效  设置见feignservice
 *
 * @author CHOOSE1
 * @date 2022-09-14 20:59:53
 */
// @Configuration
public class FeignConfig {

    // 日志配置
    @Bean
    public Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }

    // 超时配置
/*    @Bean
    public Request.Options options() {
        return new Request.Options(1000, 1000);
    }*/

    // 自定义拦截器
    @Bean
    public CustomFeignInterceptor customFeignInterceptor() {
        return new CustomFeignInterceptor();
    }

}
