package com.cash.manager.controller.params;

import lombok.Data;

import java.util.List;

/**
 * 批量删除订单id
 *
 * @author MiaoShaoDong
 * @date 16:46 2020/11/9
 */
@Data
public class DeleteParams {
    List<Long> ids;
}
