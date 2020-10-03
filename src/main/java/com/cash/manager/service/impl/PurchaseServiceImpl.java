package com.cash.manager.service.impl;

import com.cash.manager.entity.User;
import com.cash.manager.mapper.UserMapper;
import com.cash.manager.service.PurchaseService;
import com.cash.manager.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author MiaoShaoDong
 * @date 14:24 2020/9/17
 */
@Service(value = "PurchaseService")
public class PurchaseServiceImpl implements PurchaseService {

    @Override
    public List<User> getUserList() {
        return null;
    }

    @Override
    public User getUserByName(String name) {
        return null;
    }

    @Override
    public User loginPage(String name, String password) {
        return null;
    }
}
