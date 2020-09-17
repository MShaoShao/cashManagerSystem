package com.cash.manager.mapper;

import com.cash.manager.entity.User;
import org.apache.ibatis.annotations.Param;
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
     *获取用户列表
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
    @Select("select name,id from user where name=#{name}")
    User getUserByName(@Param("name") String name);

    /**
     *获取登录用户实体类
     *
     * @param name 用户名
     * @param password 密码
     * @return 对应的登录用户实体类
     */
    User loginPage(String name, String password);
}
