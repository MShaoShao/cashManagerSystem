package com.cash.manager.controller;

import com.cash.manager.entity.Order;
import com.cash.manager.mapper.bean.OrderParam;
import com.cash.manager.service.CashService;
import com.cash.manager.vo.OrderVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 订单管理接口
 *
 * @author MiaoShaoDong
 * @date 12:59 2020/9/19
 */
@RestController
@RequestMapping(value = "/order",
        produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
        consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
@Slf4j
public class OrderManegeController {
    @Autowired
    CashService cashService;

    /**
     * 新增订单信息
     *
     * @return 新增后的订单信息
     */
    @RequestMapping("/add")
    private Order addOrder(@RequestBody OrderVo vo) {
        return cashService.saveOrders(vo);
    }
    /**
     * 删除订单信息
     *
     * @return 删除后的订单信息
     */
    @RequestMapping("/delete")
    private String deleteOrder(@RequestBody OrderVo vo) {
        return cashService.deleteOrders(vo.getId());
    }

    /**
     * 更新订单信息
     *
     * @return 更新后的订单信息
     */
    @RequestMapping("/update")
    private Order updateOrder(@RequestBody OrderVo vo) {
        return cashService.updateOrders(vo);
    }
    /**
     * 查询订单信息
     *
     * @return 查询到的订单信息
     */
    @GetMapping("/query")
    private List<Order> queryOrder(@RequestBody OrderParam vo) {
        return cashService.getOrderList(vo);
    }

}
