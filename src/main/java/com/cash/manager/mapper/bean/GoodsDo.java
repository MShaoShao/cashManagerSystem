package com.cash.manager.mapper.bean;

import lombok.Data;

/**
 * 货物信息实体
 *
 * @author MiaoShaoDong
 * @date 11:23 2020/9/18
 */
@Data
public class GoodsDo {
    private Integer id;
    private Integer orderType;
    private Integer orderId;
    /**
     * 钢板数量
     */
    private double orderNums;
    /**
     * 钢板长度
     */
    private double plateLength;
    /**
     * 完成人
     */
    private String workName;
    /**
     * 货物完成时间
     */
    private long createTime;
}
