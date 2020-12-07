package com.cash.manager.service.impl;

import com.cash.manager.entity.User;
import com.cash.manager.mapper.UserMapper;
import com.cash.manager.service.GoodsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author MiaoShaoDong
 * @date 14:24 2020/9/17
 */
@Service(value = "GoodsService")
public class GoodsServiceImpl implements GoodsService {

    /**
     * 获取用户列表
     *
     * @return 用户列表
     */
    @Override
    public List<User> getUserList() {
        return null;
    }

    /**
     * 根据用户名获取用户信息
     *
     * @param name 用户名
     * @return 对应的用户信息
     */
    @Override
    public User getUserByName(String name) {
        return null;
    }

    /**
     * 获取登录用户实体类
     *
     * @param name     用户名
     * @param password 密码
     * @return 对应的登录用户实体类
     */
    @Override
    public User loginPage(String name, String password) {
        return null;
    }
}
