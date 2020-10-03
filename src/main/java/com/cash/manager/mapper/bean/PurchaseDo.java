package com.cash.manager.mapper.bean;

import lombok.Data;

/**
 * 花销信息实体
 *
 * @author MiaoShaoDong
 * @date 11:23 2020/9/18
 */
@Data
public class PurchaseDo {
    /**
     * 消费id
     */
    private Integer id;
    /**
     * 花销人
     */
    private String expName;
    /**
     * 花销类型
     */
    private ExpType expType;
    /**
     * 吨数
     */
    private double expNums;
    /**
     * 单价
     */
    private double unitMoney;
    /**
     * 花销人
     */
    private double sumMoney;
    /**
     * 订单创建时间
     */
    private long createTime;
}
