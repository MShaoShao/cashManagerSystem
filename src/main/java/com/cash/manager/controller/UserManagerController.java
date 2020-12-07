package com.cash.manager.controller;

import com.cash.manager.controller.params.DeleteParams;
import com.cash.manager.controller.params.UserParams;
import com.cash.manager.entity.ApiResult;
import com.cash.manager.entity.User;
import com.cash.manager.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * 用户登录和查询用户信息rest接口
 *
 * @author MiaoShaoDong
 * @date 14:29 2020/9/17
 */
@RestController
@RequestMapping(value = "/user")
@Slf4j
public class UserManagerController {

    @Autowired
    private UserService userService;

    /**
     * 新增花销信息
     *
     * @return 新增后的花销信息
     */
    @RequestMapping("/add")
    private User addUser(@RequestBody UserParams vo) {
        return userService.saveUser(vo);
    }

    /**
     * 批量删除花销信息
     *
     * @return 删除后的花销信息
     */
    @RequestMapping("/deleteByIds")
    private List<Long> deleteUsers(@RequestBody DeleteParams deleteParams) {
        return userService.deleteUserByIds(deleteParams.getIds());
    }

    /**
     * 更新花销信息
     *
     * @return 更新后的花销信息
     */
    @RequestMapping("/update")
    private User deleteUsers(@RequestBody UserParams vo) {
        return userService.updateUser(vo);
    }

    /**
     * 更新花销信息
     *
     * @return 更新后的花销信息
     */
    @RequestMapping("/query")
    private ApiResult queryResults(@RequestBody UserParams vo) {
        return ApiResult.ok(userService.getUserList(vo));
    }

    /**
     * 查询特定id的订单信息
     *
     * @return 查询到的订单信息
     */
    @RequestMapping("/queryByUserId")
    private User queryUser(@RequestParam("id") Integer id) {
        return userService.getUserById(id);
    }

}
