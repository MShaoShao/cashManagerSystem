package com.cash.manager.controller;

import com.cash.manager.controller.params.DeleteParams;
import com.cash.manager.entity.ApiResult;
import com.cash.manager.entity.Order;
import com.cash.manager.controller.params.OrderParam;
import com.cash.manager.service.CashService;
import com.cash.manager.vo.OrderAndGoods;
import com.cash.manager.vo.OrderVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 订单管理接口
 *
 * @author MiaoShaoDong
 * @date 12:59 2020/9/19
 */
@RestController
@RequestMapping(value = "/order"
//        produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
//        consumes = MediaType.APPLICATION_JSON_UTF8_VALUE
)
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
    private String deleteOrder(@RequestParam("id") Long id) {
        return cashService.deleteOrders(id);
    }

    /**
     * 批量删除订单信息
     *
     * @return 删除后的订单信息
     */
    @RequestMapping("/deleteByIds")
    private List<Long> deleteOrder(@RequestBody DeleteParams deleteParams) {
        return cashService.deleteOrdersByIds(deleteParams.getIds());
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
    @RequestMapping("/query")
    private ApiResult queryOrder(@RequestBody OrderParam queryParam) {
        queryParam.setPageNum((queryParam.getPageNum() - 1) * queryParam.getPageSize());
        return ApiResult.ok(cashService.getOrderList(queryParam));
    }

    /**
     * 查询特定id的订单信息
     *
     * @return 查询到的订单信息
     */
    @RequestMapping("/queryByOrderId")
    private OrderAndGoods queryOrder(@RequestParam("id") Integer id) {
        return cashService.getOrderById(id);
    }

}
