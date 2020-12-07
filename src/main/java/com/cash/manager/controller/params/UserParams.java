package com.cash.manager.controller.params;

import com.cash.manager.mapper.bean.type.ExpType;
import lombok.Data;

/**
 * 查询订单参数类
 *
 * @author MiaoShaoDong
 * @date 14:48 2020/9/18
 */
@Data
public class UserParams {
    /**
     * 消费id
     */
    private Integer id;
    /**
     * 用户名
     */
    private String userName;
    /**
     * 密码
     */
    private String password;
    /**
     *性别
     */
    private Integer sex;
}
