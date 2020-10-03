package com.cash.manager.service;

import com.cash.manager.entity.User;

import java.util.List;

/**
 * 用户信息实现接口
 *
 * @author MiaoShaoDong
 * @date 14:23 2020/9/17
 */
public interface GoodsService {
    /**
     * 获取用户列表
     *
     * @return 用户列表
     */
    List<User> getUserList();

    /**
     * 根据用户名获取用户信息
     *
     * @param name 用户名
     * @return 对应的用户信息
     */
    User getUserByName(String name);

    /**
     * 获取登录用户实体类
     *
     * @param name     用户名
     * @param password 密码
     * @return 对应的登录用户实体类
     */
    User loginPage(String name, String password);
}
