package com.order.seata.Enum;

import com.order.seata.api.IRusult;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 实现返回枚举
 *
 * @author CHOOSE1
 * @date 2022-09-21 09:18:46
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum ResultEnum implements IRusult {

    SUCCESS(2001, "接口调用成功"),
    VALIDATE_FAILED(2002, "参数校验失败"),
    COMMON_FAILED(2003, "接口调用失败"),
    FORBIDDEN(2004, "没有权限访问资源");

    private Integer code;
    private String message;

}
