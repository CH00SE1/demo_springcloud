package com.order.exception;

import com.alibaba.csp.sentinel.adapter.spring.webmvc.callback.BlockExceptionHandler;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.authority.AuthorityException;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeException;
import com.alibaba.csp.sentinel.slots.block.flow.FlowException;
import com.alibaba.csp.sentinel.slots.block.flow.param.ParamFlowException;
import com.alibaba.csp.sentinel.slots.system.SystemBlockException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * @author CHOOSE1
 * @date 2022-09-15 16:09:11
 */
@Component
public class MyBlockExceptionHandler implements BlockExceptionHandler {

    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, BlockException e) throws Exception {
        Map<String, String> errors = new HashMap<>();
        errors.put("type", e.getClass().getName());
        if (e instanceof FlowException) {
            errors.put("message", "服务限流");
        } else if (e instanceof DegradeException) {
            errors.put("message", "服务降级了");
        } else if (e instanceof ParamFlowException) {
            errors.put("message", "热点参数限流");
        } else if (e instanceof SystemBlockException) {
            errors.put("message", "触发系统保护");
        } else if (e instanceof AuthorityException) {
            errors.put("message", "授权规则不通过");
        } else {
            errors.put("message", "其他异常");
        }
        errors.put("path", httpServletRequest.getRequestURI());
        httpServletResponse.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        httpServletResponse.setCharacterEncoding("UTF-8");
        httpServletResponse.setContentType(MediaType.APPLICATION_JSON_VALUE);
        new ObjectMapper().writeValue(httpServletResponse.getWriter(), errors);
    }

}
