package com.cash.manager.mapper.bean;

import lombok.Data;

/**
 * 查询订单参数类
 *
 * @author MiaoShaoDong
 * @date 14:48 2020/9/18
 */
@Data
public class OrderParam {
    /**
     * 订单Id
     */
    private Integer id;
    /**
     * 订单类型 0单板
     */
    private OrderType orderType;
    /**
     * 订单金额
     */
    private Double totalPrice;
    /**
     * 订货人
     */
    private String orderName;
    /**
     * 出货人
     */
    private String saleName;
    /**
     * 金额是否结清 0结清 1未结清
     */
    private Integer isSettled;
    /**
     * 订单是否完成 0完成 1未完成
     */
    private Integer isFinished;
    /**
     * 开始时间
     */
    private Long startTime;
    /**
     * 结束时间
     */
    private Long endTime;

}
