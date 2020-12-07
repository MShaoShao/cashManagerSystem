package com.cash.manager.service;

import com.cash.manager.controller.params.PurchaseParam;
import com.cash.manager.entity.Order;
import com.cash.manager.entity.Purchase;
import com.cash.manager.controller.params.OrderParam;
import com.cash.manager.vo.OrderAndGoods;
import com.cash.manager.vo.OrderVo;

import java.util.List;

/**
 * 花销信息实现接口
 *
 * @author MiaoShaoDong
 * @date 14:23 2020/9/17
 */
public interface PurchaseService {
    /**
     * 根据查询条件获取花销信息列表
     *
     * @param param 查询条件
     * @return 花销信息列表
     */
    List<Purchase> getPurchaseList(PurchaseParam param);

    /**
     * 保存花销信息
     *
     * @param record 花销信息
     * @return 保存成功的花销信息
     */
    Purchase savePurchases(PurchaseParam record);

    /**
     * 更新花销信息
     *
     * @param record 花销信息
     * @return 更新后的花销信息
     */
    Purchase updatePurchases(PurchaseParam record);

    /**
     * 查询特定花销id对应的花销信息
     * @param id
     * @return
     */
    Purchase getPurchaseById(Integer id);

    /**
     * 批量删除花销信息
     * @param ids 花销id
     * @return 删除失败的id数组
     */
    List<Long> deletePurchasesByIds(List<Long> ids);
}
