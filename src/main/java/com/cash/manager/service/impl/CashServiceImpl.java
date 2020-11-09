package com.cash.manager.service.impl;

import com.cash.manager.entity.Order;
import com.cash.manager.mapper.CashMapper;
import com.cash.manager.mapper.GoodsMapper;
import com.cash.manager.mapper.bean.*;
import com.cash.manager.service.CashService;
import com.cash.manager.vo.OrderAndGoods;
import com.cash.manager.vo.OrderVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * @author MiaoShaoDong
 * @date 14:24 2020/9/17
 */
@Slf4j
@Service(value = "CashService")
public class CashServiceImpl implements CashService {
    @Resource
    private CashMapper cashMapper;
    @Resource
    private GoodsMapper goodsMapper;

    public static void main(String[] args) {
        LocalDateTime nowTime = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String createTime = dateTimeFormatter.format(nowTime);
        System.out.println(createTime);
    }

    @Override
    public List<Order> getOrderList(OrderParam param) {
        //查询订单信息
        List<OrderDo> orderDoList = cashMapper.getOrderList(param);
        //转换订单信息
        List<Order> orders = new ArrayList<>();
        orderDoList.forEach(orderDo -> {
            orders.add(convertOrders(orderDo));
        });
        return orders;
    }

    private Order convertOrders(OrderDo orderDo) {
        Order order = new Order();
        order.setCreateTime(orderDo.getCreateTime().getTime());
        order.setId(orderDo.getId());
        order.setIsFinished(orderDo.getIsFinished());
        order.setIsSettled(orderDo.getIsSettled());
        order.setOrderName(orderDo.getOrderName());
        order.setSaleName(orderDo.getSaleName());
        order.setOrderType(OrderType.getTypeName(orderDo.getOrderType()));
        order.setTotalPrice(orderDo.getTotalPrice());
        return order;
    }

    /**
     * 检测参数是否为空
     *
     * @param record 待检测的参数
     */
    private void checkOrderVO(OrderVo record) {
        checkNotNull(record, "record返回数据不合理，返回null! ");
    }

    @Override
    public Order saveOrders(OrderVo record) {
        //验证入参
        checkOrderVO(record);
        // 封装前端订单对象
        OrderDo orderDo = convertOrder(record);
        //计算某一类型钢板的总价
        double sum = 0d;
        List<Double> nums = record.getOrderNums();
        List<Double> lengths = record.getPlateLength();
        for (int i = 0; i < nums.size(); i++) {
            sum += nums.get(i) * lengths.get(i) * record.getUnitPrice();
        }
        orderDo.setTotalPrice(sum);
        cashMapper.insert(orderDo);
        //查询刚插入订单信息的id
        LocalDateTime nowTime = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String time = dateTimeFormatter.format(nowTime);
        int orderId = cashMapper.queryOrderId(record.getOrderType().getTypeId(), time, record.getOrderName());
        // 封装货物信息对象,并将每一条货物信息记录插入到表中
        GoodsDo goodsDo = convertGoods(record);
        goodsDo.setOrderId(orderId);
        for (int i = 0; i < nums.size(); i++) {
            goodsDo.setOrderNums(nums.get(i));
            goodsDo.setPlateLength(lengths.get(i));
            goodsMapper.insert(goodsDo);
        }
        //返回创建好的订单信息
        return convertOrders(cashMapper.getOrder(orderId));
    }

    @Override
    public Order updateOrders(OrderVo record) {
        log.info("当前订单信息为：{}",record);
        //更新订单信息
        OrderDo orderDo = convertOrder(record);
        orderDo.setId(record.getId());
        //计算某一类型钢板的总价
        double sum = 0d;
        List<Double> nums = record.getOrderNums();
        List<Double> lengths = record.getPlateLength();
        for (int i = 0; i < nums.size(); i++) {
            sum += nums.get(i) * lengths.get(i) * record.getUnitPrice();
        }
        orderDo.setTotalPrice(sum);
        //更新订单信息
        cashMapper.update(orderDo);
        //删除订单信息关联的获取信息
        goodsMapper.deleteById(record.getId());
        //重新插入更新后的订单关联的货物信息
        GoodsDo goodsDo = convertGoods(record);
        goodsDo.setOrderId(record.getId());
        for (int i = 0; i < nums.size(); i++) {
            goodsDo.setOrderNums(nums.get(i));
            goodsDo.setPlateLength(lengths.get(i));
            goodsMapper.insert(goodsDo);
        }
        //返回更新后的订单信息
        return convertOrders(cashMapper.getOrder(record.getId()));
    }

    @Override
    public String deleteOrders(long id) {
        int deleteNums = cashMapper.deleteById(id);
        int deleteGoodNums = goodsMapper.deleteById(id);
        return "删除订单的条数为："+deleteNums+"删除订单对应货物数量的条数为："+deleteGoodNums;
    }

    @Override
    public OrderAndGoods getOrderById(Integer id) {
       OrderDo orderDo =  cashMapper.getOrder(id);
       List<GoodsDo> goodsDo = goodsMapper.getGoodsDo(id);
       return convertOrdersAndGoods(orderDo,goodsDo);
    }

    /**
     * 批量删除订单信息
     *
     * @param ids
     * @return ding
     */
    @Override
    public List<Long> deleteOrdersByIds(List<Long> ids) {
        List<Long> disableDeleteIds = new ArrayList<>();
        ids.forEach(id->{
            int deleteNums = cashMapper.deleteById(id);
            int deleteGoodNums = goodsMapper.deleteById(id);
            if (deleteNums == 0 && deleteGoodNums ==0){
                disableDeleteIds.add(id);
            }
        });
        return disableDeleteIds;
    }

    /**
     * 处理订单信息和订单id 对应的货物信息
     * @param orderDo 订单信息
     * @param goodsDo 货物信息
     * @return 处理好的订单信息
     */
    private OrderAndGoods convertOrdersAndGoods(OrderDo orderDo, List<GoodsDo> goodsDo) {
        OrderAndGoods orderAndGoods = new OrderAndGoods();
        BeanUtils.copyProperties(orderDo,orderAndGoods,"goodsParams");
        orderAndGoods.setOrderType(OrderType.getTypeName(orderDo.getOrderType()));
        orderAndGoods.setGoodsParams(goodsDo);
        return orderAndGoods;
    }

    /**
     * 封装货物信息参数
     *
     * @param record  待封装的货物信息
     * @return 封装好的货物信息
     */
    private GoodsDo convertGoods(OrderVo record) {
        GoodsDo goodsDo = new GoodsDo();
        goodsDo.setOrderType(record.getOrderType().getTypeId());
        goodsDo.setWorkName(record.getSaleName());
        return goodsDo;
    }

    /**
     * 封装订单信息
     *
     * @param record 待封装的订单信息
     * @return 封装好的订单信息
     */
    private OrderDo convertOrder(OrderVo record) {
        OrderDo orderDo = new OrderDo();
        orderDo.setIsFinished(record.getIsFinished());
        orderDo.setIsSettled(record.getIsSettled());
        orderDo.setOrderName(record.getOrderName());
        orderDo.setSaleName(record.getSaleName());
        orderDo.setOrderType(record.getOrderType().getTypeId());
        orderDo.setUnitPrice(record.getUnitPrice());
        return orderDo;
    }
}
