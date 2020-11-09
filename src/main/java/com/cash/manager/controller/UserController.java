package com.cash.manager.controller;

import com.cash.manager.entity.User;
import com.cash.manager.service.UserService;
import com.cash.manager.utill.Json;
import com.cash.manager.utill.Tool;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.util.ObjectUtils.isEmpty;


/**
 * 用户登录和查询用户信息rest接口
 *
 * @author MiaoShaoDong
 * @date 14:29 2020/9/17
 */
@Controller
@RequestMapping(value = "/user")
@Slf4j
public class UserController {

    private static final String USER_NAME = "username";
    private static final String PASS_WORD = "pwd";
    @Autowired
    private UserService userService;


    /**
     * 登录界面 调用接口
     *
     * @return 跳转到登录页面
     */
    @RequestMapping("/login")
    private String index() {
        return "login.html";
    }

    /**
     * 输入账号密码进行登录校验，并返回登录结果
     *
     * @param request 请求信息
     * @param session 会话信息
     * @return 登录结果
     */
    @RequestMapping(value="/loginPage")
    private ModelAndView login(HttpServletRequest request, HttpSession session) {
        ModelAndView modelAndView = new ModelAndView();
        String userName = request.getParameter(USER_NAME);
        String password = request.getParameter(PASS_WORD);
        User userDo = userService.loginPage(userName, password);
        log.info("userDo is: {}", userDo);
        if (isEmpty(userDo)) {
            modelAndView.clear();
            modelAndView.setViewName("login");
            return modelAndView;
        }
        session.setAttribute("tname", userDo.getName());
        log.info("name is: {}", userDo.getName());
        modelAndView.setViewName("homePage");
        return modelAndView;
    }

    @RequestMapping("/getUserList")
    private void getUserList(HttpServletResponse response)throws Exception{
        List<User> users =  userService.getUserList();
        if(users.isEmpty()){
            Json.toJson(new Tool(false,7000,"没有数据",null),response);
            return;
        }
        List<User> userList = new ArrayList<User>();
        for (User entity : users) {
            User user = new User();
            user.setId(entity.getId());
            user.setName(entity.getName());
            user.setPassword(entity.getPassword());
            user.setSex(entity.getSex());
            userList.add(entity);
        }
        Tool result = new Tool(true,200,"成功",userList);
        Json.toJson(result,response);
    }
}
