package com.order.interceptor;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author CHOOSE1
 * @date 2022-09-15 08:23:40
 */
public class CustomFeignInterceptor implements RequestInterceptor {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void apply(RequestTemplate requestTemplate) {
        // todo 拦截器
        requestTemplate.header("xxx","xxx");

        requestTemplate.query("name","open");

        logger.info("feign 拦截器");

    }
}
