package com.hb.takeawayserver.service.impl;

import com.hb.takeawayserver.pojo.User;
import com.hb.takeawayserver.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

/**
 * @author hb
 * @creat 2022-08-13-2022/8/13
 **/

@Component
public class UserDetailsServiceImp implements UserDetailsService {

    @Autowired
    IUserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.getUserByUserName(username);
        if(user == null)
            throw new UsernameNotFoundException("用户不存在或被禁用!");
        return user;
    }

}
