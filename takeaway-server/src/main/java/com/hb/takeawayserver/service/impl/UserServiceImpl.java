package com.hb.takeawayserver.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hb.takeawayserver.pojo.RespBean;
import com.hb.takeawayserver.pojo.User;
import com.hb.takeawayserver.mapper.UserMapper;
import com.hb.takeawayserver.pojo.UserVO;
import com.hb.takeawayserver.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hb.takeawayserver.utils.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *  用户服务实现类
 * </p>
 *
 * @author hb
 * @since 2022-10-05
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Resource
    private UserMapper userMapper;
    @Value("${jwt.tokenHead}")
    private String tokenHead;

    @Override
    public RespBean login(UserVO user) {
        String username = user.getUsername();
        String password = user.getPassword();
        //如果说密码或者是账号为空
        if(!StringUtils.hasText(username) || !StringUtils.hasText(password))
            return RespBean.error("用户名或者密码不能为空！");

        UserDetails userDetails = null;
        try {
            userDetails = userDetailsService.loadUserByUsername(username);
        } catch (UsernameNotFoundException e) {
            return RespBean.error(e.getMessage());
        }
        if(!passwordEncoder.matches(password, userDetails.getPassword())){
            return RespBean.error("用户名或密码错误");
        }

        String jwtToken = jwtTokenUtil.generateToken(userDetails);
        Map<String, String> tokenMap = new HashMap<>();
        tokenMap.put("token", jwtToken);
        tokenMap.put("tokenHead", tokenHead);
        return  RespBean.success("登录成功", tokenMap);
    }

    @Override
    public User getUserByUserName(String username) {
        return userMapper.selectOne(new QueryWrapper<User>()
                .eq("username", username)
                .eq("enabled", true));
    }
}
