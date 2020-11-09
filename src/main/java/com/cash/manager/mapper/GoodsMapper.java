package com.cash.manager.mapper;

import com.cash.manager.mapper.bean.GoodsDo;
import com.cash.manager.mapper.bean.GoodsParam;
import com.cash.manager.mapper.bean.OrderDo;
import com.cash.manager.mapper.bean.OrderParam;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 货物数量记录管理mapper
 *
 * @author MiaoShaoDong
 * @date 11:27 2020/9/18
 */
@Mapper
@Repository
public interface GoodsMapper {
    /**
     * 查询货物列表
     *
     * @param param 查询货物参数
     * @return 查询相应条件的货物列表
     */
    List<GoodsDo> getGoodList(GoodsParam param);

    /**
     * 根据货物id，删除货物
     *
     * @param orderId 货物id
     * @return 删除成功返回空
     */
    int deleteById(@Param("orderId") long orderId);

    /**
     * 保存货物信息
     *
     * @param record 货物信息
     * @return 保存成功的信息
     */
    int insert(GoodsDo record);

    /**
     * 更新货物信息
     *
     * @param record 需要更新的信息
     * @return 更新后的货物信息
     */
    int update(GoodsDo record);


    /**
     * 根据订单id，查询货物信息
     *
     * @param id 订单id
     * @return 查询到了对应货物信息
     */
    List<GoodsDo> getGoodsDo(@Param("id") int id);
}
