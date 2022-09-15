package com.sentinel.controller;

import com.alibaba.csp.sentinel.Entry;
import com.alibaba.csp.sentinel.SphU;
import com.alibaba.csp.sentinel.Tracer;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
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
        FlowRule flowRule2 = new FlowRule();
        // 设置那个资源进行流控
        flowRule2.setResource(USER_RESOUCE_NAME);
        // 设置流控规则QPS
        flowRule2.setGrade(RuleConstant.FLOW_GRADE_QPS);
        // 设置受保护的资源阈值
        flowRule2.setCount(1);
        rules.add(flowRule2);
        // 加载配置规则
        FlowRuleManager.loadRules(rules);
    }

    /**
     * @return
     * @SentinelResource 改善接口中资源定义和被流控后降级的处理方法
     * 1.添加sentinel切面依赖
     * 2.配置bean SentinelResourceAspect
     * 3.value 定义资源
     * 4.blockHandler 流控降级后的处理方法 [默认该方法必须声明在同一个类中]
     */
    @GetMapping("/user")
    @SentinelResource(value = USER_RESOUCE_NAME, blockHandler = "blockHandlerForString")
    public String display(String id) {
        return id + " - 正常";
    }

    /**
     * 一定要是public
     * 返回值以及参数和原方法保持一致
     *
     * @param id
     * @param ex
     * @return
     */
    public String blockHandlerForString(String id, BlockException ex) {
        ex.printStackTrace();
        return "流控!!!";
    }

}
