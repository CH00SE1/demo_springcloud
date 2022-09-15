package com.order.service.Impl;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.order.service.IUserService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @author CHOOSE1
 * @date 2022-09-15 17:10:01
 */
@Service
public class UserServiceImpl implements IUserService {

    @Override
    @SentinelResource(value = "getUser", blockHandler = "blockHandlerGetUser")
    public Object getUser() {
        Map<String, String> users = new HashMap<>();
        users.put("name", "刘少雄");
        users.put("age", "23");
        return users;
    }

    public Object blockHandlerGetUser(BlockException ex) {
        return "限流";
    }

}
