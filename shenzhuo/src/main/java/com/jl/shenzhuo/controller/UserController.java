package com.jl.shenzhuo.controller;

import com.jl.shenzhuo.domain.User;
import com.jl.shenzhuo.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import java.util.Map;

/**
 * Create with IntelliJ IDAE
 *
 * @Author: JINLEI
 * @Description:
 * @Date: 2021/12/6
 * @Time: 0:07
 **/
@RestController
@RequestMapping("user")
public class UserController {

    @Resource
    private UserService userService;

    /**
     * 注册账号
     * @param user
     * @return
     */
    @PostMapping("create")
    public Map<String,Object> createAccount(User user) throws MessagingException {
        return userService.createAccount(user);
    }

    /**
     * 登录账号
     * @param user
     * @return
     */
    @PostMapping("login")
    public Map<String, Object> loginAccount(User user){
        return userService.loginAccount(user);
    }

    /**
     * 激活账号
     * @param confirmCode
     * @return
     */
    @GetMapping("activation")
    public Map<String, Object> activationAccount(String confirmCode){
        return userService.activationAccount(confirmCode);
    }
}
