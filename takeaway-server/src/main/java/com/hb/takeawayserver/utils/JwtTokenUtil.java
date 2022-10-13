package com.hb.takeawayserver.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author hb
 * @creat 2022-10-05-2022/10/5
 **/
@Component
public final class JwtTokenUtil {
    private final static String CLAIM_KEY_USERNAME = "sub";
    private final static String CLAIM_KEY_CREATED = "created";
    @Value("${jwt.secret}")
    private  String secret;
    @Value("${jwt.expiration}")
    private Long expiration;

    /**
     * 判断token是否过期
     * @param claims
     * @return
     */
    private  boolean isExpired(Claims claims) {
        Date expireDate = claims.getExpiration();
        //如果token有效的时间在当前时间之前就表示实效
        return expireDate.before(new Date());
    }


    /**
     * 根据用户信息生成token
     * @param userDetails
     * @return
     */
    public  String generateToken(UserDetails userDetails) {
        Map<String, Object> claims = new HashMap<>();
        claims.put(CLAIM_KEY_USERNAME, userDetails.getUsername());
        claims.put(CLAIM_KEY_CREATED, new Date());
        return generateToken(claims);
    }

    /**
     * 从jwt中获取用户名；
     * @return
     */
    public String getUserNameFromToken(String token){

        //从token中获取荷载信息；
        Claims claims = getClaimsFromToken(token);

        if(claims == null || isExpired(claims)){
            return null;
        }

        return claims.getSubject();
    }

    public String refreshToken(String token){

        //从token中获取荷载信息；
        Claims claims = getClaimsFromToken(token);

        //刷新token的创建时间
        claims.put(CLAIM_KEY_CREATED, new Date());

        return generateToken(claims);
    }

    /**
     * 根据荷载生成Token
     * @param claims
     * @return
     */
    public String generateToken(Map<String, Object> claims){
        return Jwts.builder()
                .setClaims(claims)
                .setExpiration(new Date(System.currentTimeMillis() + expiration))
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }

    private Claims getClaimsFromToken(String token){
        Claims claims;
        try {
            claims = Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token)
                    .getBody();
        } catch (Exception e) {
            claims = null;
        }
        return claims;
    }
}