package com.cash.manager.service.impl;

import com.cash.manager.entity.User;
import com.cash.manager.mapper.UserMapper;
import com.cash.manager.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author MiaoShaoDong
 * @date 14:24 2020/9/17
 */
@Service(value = "UserService")
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;

    @Override
    public List<User> getUserList() {
        return userMapper.getUserList();
    }

    @Override
    public User getUserByName(String name) {
        return userMapper.getUserByName(name);
    }

    @Override
    public User loginPage(String name, String password) {
        return userMapper.loginPage(name,password);
    }
}
