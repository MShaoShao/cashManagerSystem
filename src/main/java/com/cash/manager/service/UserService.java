package com.cash.manager.service;

import com.cash.manager.controller.params.UserParams;
import com.cash.manager.entity.Purchase;
import com.cash.manager.entity.User;
import com.cash.manager.mapper.bean.type.UserDo;

import java.util.List;

/**
 * 用户信息实现接口
 *
 * @author MiaoShaoDong
 * @date 14:23 2020/9/17
 */
public interface UserService {
    /**
     * 获取用户列表
     *
     * @param vo 查询参数
     * @return 用户列表
     */
    List<User> getUserList(UserParams vo);

    /**
     * 根据id获取用户信息
     *
     * @param id 用户id
     * @return 对应的用户信息
     */
    User getUserById(Integer id);

    /**
     * 获取登录用户实体类
     *
     * @param name     用户名
     * @param password 密码
     * @return 对应的登录用户实体类
     */
    UserDo loginPage(String name, String password);

    /**
     * 更新用户信息
     *
     * @param vo 更新参数
     * @return 更新后的用户对象
     */
    User updateUser(UserParams vo);

    /**
     * 删除用户信息
     *
     * @param ids 用户id数组
     * @return 删除不掉的id数组
     */
    List<Long> deleteUserByIds(List<Long> ids);

    /**
     * 保存用户信息
     * @param vo 用户信息
     * @return 保存后的用户信息
     */
    User saveUser(UserParams vo);
}
