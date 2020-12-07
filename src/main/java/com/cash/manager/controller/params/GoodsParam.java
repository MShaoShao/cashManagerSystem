package com.cash.manager.controller.params;

import com.cash.manager.mapper.bean.type.OrderType;
import lombok.Data;

/**
 * 查询货物参数类
 *
 * @author MiaoShaoDong
 * @date 14:48 2020/9/18
 */
@Data
public class GoodsParam {
    /**
     * 订单Id
     */
    private Integer orderId;
    /**
     * 订单类型
     */
    private OrderType orderType;
    /**
     * 完成人
     */
    private String workName;
    /**
     * 开始时间
     */
    private long startTime;
    /**
     * 结束时间
     */
    private long endTime;

}
