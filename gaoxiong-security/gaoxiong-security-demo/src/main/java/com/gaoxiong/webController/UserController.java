package com.gaoxiong.webController;

import com.gaoxiong.DTO.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author gaoxiong
 * @ClassName UserController
 * @Description TODO
 * @date 2018/10/25 2:10
 */
@RestController
public class UserController {

    @GetMapping("/user")
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
}
