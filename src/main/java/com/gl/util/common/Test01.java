package com.gl.util.common;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.Test;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;
import java.util.Date;


/**
 * @author: 山毛榉
 * @date : 2022/9/17 23:04
 * @version: 1.0
 * @description:none
 */
public class Test01 {
    /**
     * 设置Token签名密钥
     */
    private static final String SECRET_KEY = "20191224610326001";

    /**
     * 签发地:该JWT的签发者
     */
    private static final String issuer = "甘露集团";

    /**
     * 设置过期时间 30分钟
     */
    private static final long validity = 30 * 1000 * 60;

    /**
     * 生成Token
     *
     * @param account    账户
     * @param password   密码
     * @param group    组织机构
     * @param enterprise 企业账户
     * @return 返回Token
     */
    public static String createJwtToken(String account, String password, String group, String enterprise) {
        //签名算法
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        //生成签发时间，直接获取系统毫秒数
        long nowTime = System.currentTimeMillis();
        Date nowDate = new Date(nowTime);
        //通过密钥签名JWT
        byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(SECRET_KEY);
        String string = signatureAlgorithm.getJcaName();
        Key signingkey = new SecretKeySpec(apiKeySecretBytes, string);
        //设置JWT声明
        JwtBuilder jwtBuilder = Jwts.builder()
                .setId(account)
                .claim("password", password)
                .claim("groupId", group)
                .claim("enterprise", enterprise)
                .setIssuedAt(nowDate)
                .setIssuer(issuer)
                .signWith(signatureAlgorithm, signingkey);
        //过期时间
        long expMillis = nowTime + validity;
        Date exp = new Date(expMillis);
        jwtBuilder.setExpiration(exp);
        //构建JWT并将其序列化为一个紧凑的url安全字符串
        return jwtBuilder.compact();
    }

    /**
     * Token解析方法
     */
    public static Claims parseJWT(String jwt) {
        return Jwts.parser().setSigningKey(DatatypeConverter.parseBase64Binary(SECRET_KEY)).parseClaimsJws(jwt).getBody();
    }

    public static void main(String[] args) {
        //生成Token
        String token = Test01.createJwtToken("gl220107", "gl123", "周大福", "甘露");
        System.err.println(token);

        //解析Token
        Claims claims = Test01.parseJWT(token);
        System.err.println(claims.get("jti"));
        System.err.println(claims);




    }


}
