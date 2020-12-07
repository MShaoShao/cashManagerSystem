package com.cash.manager.mapper;

import com.cash.manager.controller.params.UserParams;
import com.cash.manager.entity.User;
import com.cash.manager.mapper.bean.type.UserDo;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 用户信息mapper
 *
 * @author MiaoShaoDong
 * @date 14:16 2020/9/17
 */
@Repository
public interface UserMapper {
    /**
     * 获取用户列表
     *
     * @param params 结果条件
     * @return 用户列表
     */
    List<UserDo> getUserList(UserParams params);

    /**
     * 获取最新添加的id
     *
     * @return 对应的用户信息
     */
    @Select("select Max(id) from user")
    Integer getUserId();

    /**
     * 获取登录用户实体类
     *
     * @param name     用户名
     * @param password 密码
     * @return 对应的登录用户实体类
     */
    UserDo loginPage(String name, String password);

    /**
     * 根据用户id删除用户信息
     *
     * @param id 用户id
     */
    int deleteById(Long id);

    /**
     * 根据用户id 获取用户信息
     *
     * @param id 用户id
     * @return 用户信息
     */
    UserDo getUserById(Integer id);

    /**
     * 更新用户信息
     *
     * @param userDo 用户信息对象
     */
    void update(UserDo userDo);

    /**
     * 保存用户信息
     *
     * @param userDo 用户信息对象
     */
    void insert(UserDo userDo);
}
