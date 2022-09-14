package com.order.config;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * 自定义负载均衡逻辑
 *
 * @author CHOOSE1
 * @date 2022-09-14 19:59:22
 */
public class CustomRule extends AbstractLoadBalancerRule {

    @Override
    public void initWithNiwsConfig(IClientConfig iClientConfig) {

    }

    /**
     * 自定义随机
     *
     * @param o
     * @return
     */
    @Override
    public Server choose(Object o) {
        ILoadBalancer loadBalancer = this.getLoadBalancer();
        List<Server> reachableServers = loadBalancer.getReachableServers();
        // 线程安全
        int random = ThreadLocalRandom.current().nextInt(reachableServers.size());
        return reachableServers.get(random);
    }
}
