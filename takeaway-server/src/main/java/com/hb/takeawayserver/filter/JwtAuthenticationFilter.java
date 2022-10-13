package com.hb.takeawayserver.filter;


import com.hb.takeawayserver.utils.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationDetailsSource;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Jwt登录拦截器
 * @author hb
 * @creat 2022-08-13-2022/8/13
 **/
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    @Value("${jwt.tokenHeader}")
    private String tokenHeader;

    @Value("${jwt.tokenHead}")
    private String tokenHead;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    protected AuthenticationDetailsSource<HttpServletRequest, ?> authenticationDetailsSource = new WebAuthenticationDetailsSource();

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String authHeader = request.getHeader(tokenHeader);

        //如果请求头中不存在JWT 则直接跳过后续判断；
        if(!StringUtils.hasText(authHeader) || !authHeader.startsWith(tokenHead)){
            filterChain.doFilter(request, response);
            return ;
        }

        String jwtToken = authHeader.substring(tokenHead.length());
        String username = jwtTokenUtil.getUserNameFromToken(jwtToken);
        //从token中无法获取到用户信息 或者说token存在篡改, token过期;
        if(!StringUtils.hasText(username)){
            filterChain.doFilter(request, response);
            return ;
        }

        UserDetails userDetails = null;
        try {
             userDetails = userDetailsService.loadUserByUsername(username);
        } catch (UsernameNotFoundException e) {
            throw e;
        }

        UsernamePasswordAuthenticationToken authRequest =
                new UsernamePasswordAuthenticationToken(
                        userDetails,
                        null,
                        userDetails.getAuthorities());
        userDetails(request, authRequest);
        SecurityContextHolder.getContext().setAuthentication(authRequest);

        filterChain.doFilter(request, response);
    }

    private void userDetails(HttpServletRequest request, UsernamePasswordAuthenticationToken authRequest) {
        authRequest.setDetails(this.authenticationDetailsSource.buildDetails(request));

    }
}

