package com.cash.manager.controller.params;

import com.cash.manager.mapper.bean.type.ExpType;
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
     * 开始时间
     */
    private Integer startTime;
    /**
     * 结束时间
     */
    private Integer endTime;
    /**
     * 花销描述
     */
    private String description;
    /**
     * 花销总金额
     */
    private double sumMoney;

    /**
     * 当前页
     */
    private Integer pageNum;
    /**
     * 当页大小
     */
    private Integer PageSize;

}
