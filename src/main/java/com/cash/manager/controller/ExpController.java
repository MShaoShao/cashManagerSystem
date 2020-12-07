package com.cash.manager.controller;

import com.cash.manager.controller.params.DeleteParams;
import com.cash.manager.controller.params.PurchaseParam;
import com.cash.manager.entity.ApiResult;
import com.cash.manager.entity.Purchase;
import com.cash.manager.service.PurchaseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author MiaoShaoDong
 * @date 16:35 2020/11/20
 */
@RestController
@RequestMapping(value = "/exp")
@Slf4j
public class ExpController {
    @Autowired
    PurchaseService service;

    /**
     * 新增花销信息
     *
     * @return 新增后的花销信息
     */
    @RequestMapping("/add")
    private Purchase addPurchase(@RequestBody PurchaseParam vo) {
        return service.savePurchases(vo);
    }

    /**
     * 批量删除花销信息
     *
     * @return 删除后的花销信息
     */
    @RequestMapping("/deleteByIds")
    private List<Long> deletePurchases(@RequestBody DeleteParams deleteParams) {
        return service.deletePurchasesByIds(deleteParams.getIds());
    }

    /**
     * 更新花销信息
     *
     * @return 更新后的花销信息
     */
    @RequestMapping("/update")
    private Purchase deletePurchases(@RequestBody PurchaseParam vo) {
        return service.updatePurchases(vo);
    }

    /**
     * 更新花销信息
     *
     * @return 更新后的花销信息
     */
    @RequestMapping("/query")
    private ApiResult queryResults(@RequestBody PurchaseParam vo) {
        return ApiResult.ok(service.getPurchaseList(vo));
    }

    /**
     * 查询特定id的订单信息
     *
     * @return 查询到的订单信息
     */
    @RequestMapping("/queryByPurchaseId")
    private Purchase queryPurchase(@RequestParam("id") Integer id) {
        return service.getPurchaseById(id);
    }

}
