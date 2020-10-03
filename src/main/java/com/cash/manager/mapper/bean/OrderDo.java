package com.cash.manager.mapper.bean;

import lombok.Data;

import java.sql.Timestamp;

/**
 * 订单信息实体
 *
 * @author MiaoShaoDong
 * @date 11:23 2020/9/18
 */
@Data
public class OrderDo {
    private Integer id;
    private Integer orderType;
    private double unitPrice;
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
    private Timestamp createTime;
}
