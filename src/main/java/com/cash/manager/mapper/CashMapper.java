package com.cash.manager.mapper;

import com.cash.manager.mapper.bean.OrderDo;
import com.cash.manager.controller.params.OrderParam;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 订货管理mapper
 *
 * @author MiaoShaoDong
 * @date 11:27 2020/9/18
 */
@Mapper
@Repository
public interface CashMapper {
    /**
     * 查询订单列表
     *
     * @param param 查询订单参数
     * @return 查询相应条件的订单列表
     */
    List<OrderDo> getOrderList(OrderParam param);

    /**
     * 根据相应条件查询订单id
     *
     * @param orderName 订货人名称
     * @param type 订单类型
     * @param time 订货时间
     */
    int queryOrderId(@Param("type") Integer type, @Param("time") String time, @Param("orderName") String orderName);

    /**
     * 根据订单id，查询订单
     *
     * @param id 订单id
     * @return 查询到了对应订单信息
     */
    OrderDo getOrder(@Param("id") int id);

    /**
     * 根据订单id，删除订单
     *
     * @param id 订单id
     * @return 删除成功返回空
     */
    int deleteById(@Param("id") long id);

    /**
     * 保存订单信息
     *
     * @param record 订单信息
     * @return 保存成功的信息
     */
    int insert(OrderDo record);

    /**
     * 更新订单信息
     *
     * @param record 需要更新的信息
     * @return 更新后的订单信息
     */
    int update(OrderDo record);
}
