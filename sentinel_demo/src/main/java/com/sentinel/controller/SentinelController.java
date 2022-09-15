package com.sentinel.controller;

import com.alibaba.csp.sentinel.Entry;
import com.alibaba.csp.sentinel.SphU;
import com.alibaba.csp.sentinel.Tracer;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * @author CHOOSE1
 * @date 2022-09-15 10:52:21
 */
@RestController
@RequestMapping("/sentinel")
@Slf4j
public class SentinelController {

    public static final String RESOUCE_NAME = "hello";

    public static final String USER_RESOUCE_NAME = "user";

    public static final String DEGRADE_RESOUCE_NAME = "degrade";

    // 进行流控
    @GetMapping("/hello")
    public String hello() {
        Entry entry = null;
        try {
            // sentinel 针对资源进行限制
            entry = SphU.entry(RESOUCE_NAME);
            String str = "hello world";
            log.info("======" + str + "======");
            return str;
        } catch (BlockException e) {
            log.info("block!");
            return "被流控了!";
        } catch (Exception e) {
            Tracer.traceEntry(e, entry);
        } finally {
            if (entry != null) {
                entry.exit();
            }
        }
        return null;
    }

    // 定义规则
    @PostConstruct // springboot 初始化注解
    public static final void initFlowRules() {
        // 流控规则
        List<FlowRule> rules = new ArrayList<>();
        // 流控
        FlowRule flowRule = new FlowRule();
        // 设置那个资源进行流控
        flowRule.setResource(RESOUCE_NAME);
        // 设置流控规则QPS
        flowRule.setGrade(RuleConstant.FLOW_GRADE_QPS);
        // 设置受保护的资源阈值
        flowRule.setCount(1);
        rules.add(flowRule);
        // 加载配置规则
        FlowRuleManager.loadRules(rules);
    }

}
