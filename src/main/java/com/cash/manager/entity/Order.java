package com.cash.manager.entity;

import com.cash.manager.mapper.bean.OrderType;
import lombok.Data;

/**
 *
 *
 * @author MiaoShaoDong
 * @date 16:43 2020/9/18
 */
@Data
public class Order {
    private Integer id;
    private OrderType orderType;
    private double totalPrice;
    /**
     * 订货人
     */
    private String orderName;
    /**
     * 出货人
     */
    private String saleName;
    private Integer isSettled;
    private Integer isFinished;
    /**
     * 订单创建时间
     */
    private long createTime;
}
