package com.cash.manager.mapper.bean;

import com.cash.manager.mapper.bean.type.ExpType;
import lombok.Data;

import java.sql.Timestamp;

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
    private Integer expType;
    /**
     * 吨数
     */
    private double expNums;
    /**
     * 花销描述
     */
    private String description;
    /**
     * 花销总金额
     */
    private double sumMoney;
    /**
     * 订单创建时间
     */
    private Timestamp createTime;
}
