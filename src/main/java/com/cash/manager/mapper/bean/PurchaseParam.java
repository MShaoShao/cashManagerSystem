package com.cash.manager.mapper.bean;

import lombok.Data;

/**
 * 查询订单参数类
 *
 * @author MiaoShaoDong
 * @date 14:48 2020/9/18
 */
@Data
public class PurchaseParam {
    /**
     * 花销人
     */
    private String expName;
    /**
     * 花销类型
     */
    private ExpType expType;
    /**
     * 开始时间
     */
    private long startTime;
    /**
     * 结束时间
     */
    private long endTime;

}
