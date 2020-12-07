package com.cash.manager.vo;

import com.cash.manager.mapper.bean.GoodsDo;
import com.cash.manager.mapper.bean.type.OrderType;
import lombok.Data;

import java.sql.Timestamp;
import java.util.List;

/**
 * @author MiaoShaoDong
 * @date 16:31 2020/10/30
 */
@Data
public class OrderAndGoods {
    private Integer id;
    private OrderType orderType;
    private double totalPrice;
    private double unitPrice;
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
    private List<GoodsDo> goodsParams;
}
