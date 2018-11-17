package com.gaoxiong.webController;

import com.gaoxiong.DTO.User;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author gaoxiong
 * @ClassName UserController
 * @Description TODO
 * @date 2018/10/25 2:10
 */
@RestController
@RequestMapping("/user")
public class UserController {


    /**
     * 三种获得当前已登录用户信息的方法
     * @return
     */
    @RequestMapping("/me")
    public Object getCurrentUser(){
        return SecurityContextHolder.getContext().getAuthentication();
    }
    @RequestMapping("/me1")
    public Object getCurrentUser1( Authentication authentication ){
        return authentication;
    }
    @RequestMapping("/me2")
    public Object getCurrentUser2( @AuthenticationPrincipal UserDetails userDetails ){
        return userDetails;
    }

    @GetMapping("")
    @ResponseBody
    public List<User> query(){
        List<User> list = new ArrayList<>();
        User tom = new User("tom", "123456");
        User jerry = new User("jerry", "123456");
        list.add(tom);
        list.add(jerry);
        System.out.println("进入查询用户服务");
        return list;
    }
    @GetMapping("/{id}")
    @ApiOperation(value = "查询单个用户的服务")
    public User queryById(@ApiParam(value = "用户主键ID") @PathVariable String id ){
        return new User("tom","123455" );
    }
}
