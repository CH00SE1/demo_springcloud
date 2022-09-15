package com.order.exception;

import com.netflix.loadbalancer.IRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author CHOOSE1
 * @date 2022-09-14 19:11:51
 */
@Configuration
public class RibbonConfig {

    @Bean
    public IRule iRule() {
        return new CustomRule();
    }

}
