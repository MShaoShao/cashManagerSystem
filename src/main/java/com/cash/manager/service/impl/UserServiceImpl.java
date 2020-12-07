package com.cash.manager.service.impl;

import com.cash.manager.controller.params.UserParams;
import com.cash.manager.entity.User;
import com.cash.manager.mapper.UserMapper;
import com.cash.manager.mapper.bean.type.UserDo;
import com.cash.manager.service.UserService;
import com.google.common.base.Preconditions;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author MiaoShaoDong
 * @date 14:24 2020/9/17
 */
@Service(value = "UserService")
@Slf4j
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;

    /**
     * 获取用户列表
     *
     * @param vo 查询参数
     * @return 用户列表
     */
    @Override
    public List<User> getUserList(UserParams vo) {
        //查询用户信息
        List<UserDo> userDos = userMapper.getUserList(vo);
        //转换用户信息
        List<User> users = new ArrayList<>();
        userDos.forEach(userDo -> {
            users.add(convertUserDo(userDo));
        });
        return users;
    }

    private User convertUserDo(UserDo userDo) {
        User user = new User();
        BeanUtils.copyProperties(userDo, user);
        return user;
    }

    /**
     * 根据id获取用户信息
     *
     * @param id 用户id
     * @return 对应的用户信息
     */
    @Override
    public User getUserById(Integer id) {
        return convertUserDo(userMapper.getUserById(id));
    }

    @Override
    public UserDo loginPage(String name, String password) {
        return userMapper.loginPage(name, password);
    }

    /**
     * 更新用户信息
     *
     * @param record 更新参数
     * @return 更新后的用户对象
     */
    @Override
    public User updateUser(UserParams record) {
        log.info("当前前端参数为：{}", record);
        //更新用户信息
        UserDo userDo = convertUser(record);
        userMapper.update(userDo);
        //返回更新后的用户信息
        return convertUserDo(userMapper.getUserById(record.getId()));
    }

    private UserDo convertUser(UserParams user) {
        UserDo userDo = new UserDo();
        BeanUtils.copyProperties(user, userDo);
        return userDo;
    }

    /**
     * 删除用户信息
     *
     * @param ids 用户id数组
     * @return 删除不掉的id数组
     */
    @Override
    public List<Long> deleteUserByIds(List<Long> ids) {
        List<Long> disableDeleteIds = new ArrayList<>();
        ids.forEach(id -> {
            if (userMapper.deleteById(id) == 0) {
                disableDeleteIds.add(id);
            }
        });
        return disableDeleteIds;
    }

    /**
     * 保存用户信息
     *
     * @param record 用户信息
     * @return 保存后的用户信息
     */
    @Override
    public User saveUser(UserParams record) {
        log.info("当前前端参数为：{}", record);
        // 验证前端用户对象属性
        Preconditions.checkArgument(record != null, "保存信息不能为空");
        // 转换前端用户对象
        UserDo userDo = convertUser(record);
        userMapper.insert(userDo);
        int id = userMapper.getUserId();
        log.info("添加后的用户信息id为：{}", id);
        //返回创建好的用户信息
        return convertUserDo(userMapper.getUserById(id));
    }
}
