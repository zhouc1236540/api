package com.gl.util.common;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
/**
 * @author: 山毛榉
 * @date : 2022/8/31 11:13
 * @version: 1.0
 */
public class TokenUtils {
    //设置过期时间
    private static final long EXPIRE_DATE=30*60*100000;
    //token秘钥
    private static final String TOKEN_SECRET = "ZCfasfhuaUUHufguGuwu2020BQWE";

    public static String token (String id,String ps){

        String token = "";
        try {
            //过期时间
            Date date = new Date(System.currentTimeMillis()+EXPIRE_DATE);
            //秘钥及加密算法
            Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
            //设置头部信息
            Map<String,Object> header = new HashMap<>();
            header.put("typ","JWT");
            header.put("alg","HS256");
            //携带username，password信息，生成签名
            token = JWT.create()
                    .withHeader(header)
                    .withClaim("username",id)
                    .withClaim("password",ps).withExpiresAt(date)
                    .sign(algorithm);
        }catch (Exception e){
            e.printStackTrace();
            return  null;
        }
        return token;
    }

    public static boolean verify(String token){
        /**
         * @desc   验证token，通过返回true
         * @params [token]需要校验的串
         **/
        try {
            Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
            JWTVerifier verifier = JWT.require(algorithm).build();
            DecodedJWT jwt = verifier.verify(token);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return  false;
        }
    }

    /**
     * jwt解密token
     * @param token
     * @return
     */
    public static String decodeToken(final String token) {
        String userId = null;
        try {
            JWTVerifier verifier = JWT.require(Algorithm.HMAC256(TOKEN_SECRET))
                    .build();
            DecodedJWT jwt = verifier.verify(token);
            if (jwt != null) {
                userId = jwt.getClaim("username").asString();
            }
        } catch (JWTVerificationException | IllegalArgumentException exception) {
            exception.printStackTrace();
        }
        return userId;
    }




    public static void main(String[] args) {
        String username ="gl220107";
        String password = "gl123456@.";
        String token = token(username,password);
        System.out.println(token);
        boolean b = verify(token);
        System.out.println(b);
        String integer = decodeToken(token);
        System.out.println(integer);

    }
}
