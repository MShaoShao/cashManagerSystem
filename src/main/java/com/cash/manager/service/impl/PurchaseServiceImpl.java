package com.cash.manager.service.impl;

import com.cash.manager.controller.params.PurchaseParam;
import com.cash.manager.controller.params.QueryListParams;
import com.cash.manager.entity.Purchase;
import com.cash.manager.mapper.PurchaseMapper;
import com.cash.manager.mapper.bean.PurchaseDo;
import com.cash.manager.mapper.bean.type.ExpType;
import com.cash.manager.service.PurchaseService;
import com.google.common.base.Strings;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.google.common.base.Preconditions.checkArgument;

/**
 * @author MiaoShaoDong
 * @date 14:24 2020/9/17
 */
@Slf4j
@Service(value = "PurchaseService")
public class PurchaseServiceImpl implements PurchaseService {
    @Autowired
    PurchaseMapper mapper;

    /**
     * 根据查询条件获取花销信息列表
     *
     * @param param 查询条件
     * @return 花销信息列表
     */
    @Override
    public List<Purchase> getPurchaseList(PurchaseParam param) {
        log.info("当前前端参数为：{}", param);
        QueryListParams queryParam = new QueryListParams();
        if (!Strings.isNullOrEmpty(param.getExpName())) {
            queryParam.setExpName(param.getExpName());
        }
        if (param.getExpType() != null && !"".equals(param.getExpType().toString())) {
            queryParam.setExpType(param.getExpType().getTypeId());
        }
        //查询花销信息
        List<PurchaseDo> purchaseDos = mapper.getPurchaseList(queryParam);
        //转换花销信息
        List<Purchase> purchases = new ArrayList<>();
        purchaseDos.forEach(purchaseDo -> {
            purchases.add(convertPurchaseDo(purchaseDo));
        });
        return purchases;
    }

    /**
     * 转换数据库对象为前端显示对象
     *
     * @param purchaseDo 数据库对象
     * @return 前端显示对象
     */
    private Purchase convertPurchaseDo(PurchaseDo purchaseDo) {
        Purchase purchase = new Purchase();
        BeanUtils.copyProperties(purchaseDo, purchase);
        purchase.setExpType(ExpType.getTypeName(purchaseDo.getExpType()));
        return purchase;
    }

    /**
     * 保存花销信息
     *
     * @param record 花销信息
     * @return 保存成功的花销信息
     */
    @Override
    public Purchase savePurchases(PurchaseParam record) {
        log.info("当前前端参数为：{}", record);
        // 验证前端花销对象属性
        checkParams(record);
        // 转换前端花销对象
        PurchaseDo purchaseDo = convertPurchase(record);
        purchaseDo.setExpType(record.getExpType().getTypeId());
        mapper.insert(purchaseDo);
        int id = mapper.getId();
        log.info("添加后的花销信息id为：{}", id);
        //返回创建好的花销信息
        return convertPurchaseDo(mapper.getPurchaseById(id));
    }

    /**
     * 转换前端花销对象
     *
     * @param purchaseParam 前端对象
     * @return 数据库所需对象
     */
    private PurchaseDo convertPurchase(PurchaseParam purchaseParam) {
        PurchaseDo purchaseDo = new PurchaseDo();
        BeanUtils.copyProperties(purchaseParam, purchaseDo);
        return purchaseDo;
    }

    /**
     * 验证花销参数
     *
     * @param record 待验证对象
     */
    private void checkParams(PurchaseParam record) {
        checkArgument(record.getExpType() != null, "花销类型不能为空");
        checkArgument(record.getExpName() != null, "花销人不能为空");
    }

    /**
     * 更新花销信息
     *
     * @param record 花销信息
     * @return 更新后的花销信息
     */
    @Override
    public Purchase updatePurchases(PurchaseParam record) {
        log.info("当前前端参数为：{}", record);
        //更新花销信息
        PurchaseDo purchaseDo = convertPurchase(record);
        mapper.update(purchaseDo);
        //返回更新后的花销信息
        return convertPurchaseDo(mapper.getPurchaseById(record.getId()));
    }


    /**
     * 查询特定花销id对应的花销信息
     *
     * @param id
     * @return
     */
    @Override
    public Purchase getPurchaseById(Integer id) {
        return convertPurchaseDo(mapper.getPurchaseById(id));
    }

    /**
     * 批量删除花销信息
     *
     * @param ids 花销id
     * @return 删除失败的id数组
     */
    @Override
    public List<Long> deletePurchasesByIds(List<Long> ids) {
        List<Long> disableDeleteIds = new ArrayList<>();
        ids.forEach(id -> {
            if (mapper.deleteById(id) == 0) {
                disableDeleteIds.add(id);
            }
        });
        return disableDeleteIds;
    }
}
