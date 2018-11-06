package com.gaoxiong.security.browser;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * @author gaoxiong
 * @ClassName MyUserDetailService
 * @Description TODO
 * @date 2018/11/5 23:20
 */
@Component
@Slf4j
public class MyUserDetailService implements UserDetailsService {
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername ( String username ) throws UsernameNotFoundException {
        //根据用户名查找用户信息,返回UserDetails;
        //包含用户名,密码,权限集合,是否过期,是否锁定,凭证是否过期
        //注册的时候要给密码 加密后保存
        log.info("登陆用户,用户名是:"+username);
        String encode = passwordEncoder.encode("123456");
        log.info("加密后的密码是:{encode}"+encode);
        User admin = new User(username, encode, AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));
        return admin;
    }
}
