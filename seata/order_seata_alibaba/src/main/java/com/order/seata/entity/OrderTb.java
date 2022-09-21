package com.order.seata.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 
 * </p>
 *
 * @author CH00SE 1
 * @since 2022-09-19
 */
@TableName("order_tb")
@ApiModel(value = "OrderTb对象", description = "订单表")
public class OrderTb implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("商品id")
    private Integer productId;

    @ApiModelProperty("总金额")
    private Integer totalAmount;

    @ApiModelProperty("0：待付款 1：待发货")
    private Integer status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Integer totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "OrderTb{" +
            "id = " + id +
            ", productId = " + productId +
            ", totalAmount = " + totalAmount +
            ", status = " + status +
        "}";
    }
}
