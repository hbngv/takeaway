package com.hb.takeawayserver.controller;

import com.hb.takeawayserver.pojo.RespBean;
import com.hb.takeawayserver.pojo.UserVO;
import com.hb.takeawayserver.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @author hb
 * @creat 2022-10-06-2022/10/6
 **/
@RestController
@RequestMapping("/login")
@Api(tags = "LoginController")
public class LoginController {


    @Resource
    private IUserService userService;


    @ApiOperation(value = "登录之后返回token")
    @PostMapping("/login")
    public RespBean login(@RequestBody UserVO user){
        return userService.login(user);
    }

}
