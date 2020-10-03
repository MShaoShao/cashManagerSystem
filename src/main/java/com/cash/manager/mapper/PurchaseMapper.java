package com.cash.manager.mapper;

import com.cash.manager.mapper.bean.GoodsDo;
import com.cash.manager.mapper.bean.GoodsParam;
import com.cash.manager.mapper.bean.PurchaseDo;
import com.cash.manager.mapper.bean.PurchaseParam;
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
     * @param param 查询花销参数
     * @return 查询相应条件的花销列表
     */
    List<PurchaseDo> getPurchaseList(PurchaseParam param);

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
}
