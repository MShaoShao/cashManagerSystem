package com.cash.manager.vo;

import com.cash.manager.mapper.bean.type.OrderType;
import lombok.Data;

import java.util.List;

/**
 * @author MiaoShaoDong
 * @date 17:10 2020/9/18
 */
@Data
public class OrderVo {
    private Integer id;
    private OrderType orderType;
    private Double unitPrice;
    private Double totalPrice;
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
     * 钢板数量
     */
    private List<Double> orderNums;
    /**
     * 钢板长度
     */
    private List<Double> plateLength;
}
