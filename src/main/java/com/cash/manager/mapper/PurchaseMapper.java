package com.cash.manager.mapper;

import com.cash.manager.controller.params.QueryListParams;
import com.cash.manager.mapper.bean.PurchaseDo;
import com.cash.manager.controller.params.PurchaseParam;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 进货单管理mapper
 *
 * @author MiaoShaoDong
 * @date 11:27 2020/9/18
 */
@Mapper
@Repository
public interface PurchaseMapper {
    /**
     * 查询花销列表
     *
     * @param params 查询条件
     * @return 查询相应条件的花销列表
     */
    List<PurchaseDo> getPurchaseList(QueryListParams params);

    /**
     * 根据花销id，删除花销
     *
     * @param id 花销id
     * @return 删除成功返回空
     */
    int deleteById(@Param("id") long id);

    /**
     * 保存花销信息
     *
     * @param record 花销信息
     * @return 保存成功的信息
     */
    int insert(PurchaseDo record);

    /**
     * 更新花销信息
     *
     * @param record 需要更新的信息
     * @return 更新后的花销信息
     */
    int update(PurchaseDo record);


    /**
     * 根据花销id，查询花销信息
     * @param id 花销id
     * @return 对应花销信息
     */
    PurchaseDo getPurchaseById(int id);

    /**
     * 获取新创建花销对象的id
     */
    int getId();
}
