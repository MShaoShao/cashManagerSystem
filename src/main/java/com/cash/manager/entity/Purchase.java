package com.cash.manager.entity;

import com.cash.manager.mapper.bean.type.ExpType;
import lombok.Data;

import java.sql.Timestamp;

/**
 * @author MiaoShaoDong
 * @date 15:01 2020/11/20
 */
@Data
public class Purchase {
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
