package com.gl.util.common;

import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.JWT;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: 山毛榉
 * @date : 2022/9/18 20:47
 * @version: 1.0
 * @description:none
 */
public class Test02 {
    //设置过期时间
    private static final long EXPIRE_DATE = 30 * 60 * 100000;
    //token秘钥
    private static final String TOKEN_SECRET = "SmTicket";

    /**
     * 加密Token
     *
     * @Author: RZH
     * @Date: 2020/4/6 9:25
     */
    public static String token(String  username,String password) {
        String token;
        try {
            //过期时间
            Date date = new Date(System.currentTimeMillis() + EXPIRE_DATE);
            //秘钥及加密算法
            Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
            //设置头部信息
            Map<String, Object> header = new HashMap<>();
            header.put("typ", "JWT");
            header.put("alg", "HS256");
            //携带UserId信息，生成签名
            token = JWT.create()
                    .withHeader(header)
                    .withClaim("username", username)
                    .withClaim("password",password)
                    .withExpiresAt(date)
                    .sign(algorithm);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return token;
    }

    /**
     * JWT解密
     *
     * @Author: RZH
     * @Date: 2020/4/6 9:30
     */
    public static String decodeToken(final String token) {
        String username = null;
        try {
            JWTVerifier verifier = JWT.require(Algorithm.HMAC256(TOKEN_SECRET))
                    .build();
            DecodedJWT jwt = verifier.verify(token);
            if (jwt != null) {
                username = jwt.getClaim("username").asString();
            }
        } catch (JWTVerificationException | IllegalArgumentException exception) {
            exception.printStackTrace();
        }
        return username;
    }
    /**
     * 验证Token
     *
     * @Author: RZH
     * @Date: 2020/4/5 19:35
     */
    public static boolean verify(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
            JWTVerifier verifier = JWT.require(algorithm).build();
            verifier.verify(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static void main(String[] args) {

        String token = token("123","123");
        System.out.println(token);
        String integer = decodeToken(token);
        System.out.println(integer);


    }


}
