package com.cash.manager.service;

import com.cash.manager.entity.Order;
import com.cash.manager.controller.params.OrderParam;
import com.cash.manager.vo.OrderAndGoods;
import com.cash.manager.vo.OrderVo;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 订单信息实现接口
 *
 * @author MiaoShaoDong
 * @date 14:23 2020/9/17
 */
@Service
public interface CashService {
    /**
     * 根据查询条件获取订单信息列表
     *
     * @param param 查询条件
     * @return 订单信息列表
     */
    List<Order> getOrderList(OrderParam param);

    /**
     * 保存订单信息
     *
     * @param record 订单信息
     * @return 保存成功的订单信息
     */
    Order saveOrders(OrderVo record);

    /**
     * 更新订单信息
     *
     * @param record 订单信息
     * @return 更新后的订单信息
     */
    Order updateOrders(OrderVo record);

    /**
     * 保存订单信息
     *
     * @param id 订单信息
     * @return 保存成功的订单信息
     */
    String deleteOrders(long id);

    /**
     * 查询特定订单id对应的订单信息
     * @param id
     * @return
     */
    OrderAndGoods getOrderById(Integer id);

    /**
     * 批量删除订单信息
     * @param ids 订单id
     * @return 删除失败的id数组
     */
    List<Long> deleteOrdersByIds(List<Long> ids);
}
