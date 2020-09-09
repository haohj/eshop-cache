package com.hao.eshopcache.controller;

import com.hao.eshopcache.model.User;
import com.hao.eshopcache.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 用户Controller控制器
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/getUserInfo")
    @ResponseBody
    public User getUserInfo() {
        User user = userService.findUserInfo();
        return user;
    }

    @GetMapping("/getCachedUserInfo")
    @ResponseBody
    public User getCachedUserInfo() {
        User user = userService.getCachedUserInfo();
        return user;
    }
}
