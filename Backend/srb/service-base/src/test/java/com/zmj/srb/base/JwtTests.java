package com.zmj.srb.base;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.Test;

import java.util.Date;
import java.util.UUID;

public class JwtTests {

    //过期时间，毫秒，24小时
    private static long tokenExpiration = 24*60*60*1000;
    //秘钥
    private static String tokenSignKey = "pwd123";

    @Test
    public void testCreateToken(){
        String token = Jwts.builder()
                .setHeaderParam("typ", "JWT") //令牌类型
                .setHeaderParam("alg", SignatureAlgorithm.HS256.getValue()) //签名算法

                .setSubject("admin-user") //令牌主题
                .setIssuer("zmj")//签发者
                .setAudience("sxy")//接收者
                .setIssuedAt(new Date())//签发时间
                .setExpiration(new Date(System.currentTimeMillis() + tokenExpiration)) //过期时间
                .setNotBefore(new Date(System.currentTimeMillis() + 20*1000)) //20秒后可用
                .setId(UUID.randomUUID().toString())
                .claim("nickname", "dream")
                .claim("avatar", "1.jpg")
                .signWith(SignatureAlgorithm.HS256, tokenSignKey)//签名哈希
                .compact(); //转换成字符串
        System.out.println(token);
    }

    @Test
    public void testGetUserInfo(){
        //根据上面的方法获取到的TOKEN串
        String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbi11c2VyIiwiaXNzIjoiem1qIiwiYXVkIjoic3h5IiwiaWF0IjoxNzI2NzMxODMxLCJleHAiOjE3MjY4MTgyMzEsIm5iZiI6MTcyNjczMTg1MSwianRpIjoiZjg3YmJjMTEtNDgxMi00Zjc0LTk4MTgtNmZjMWFhYTBmMDA1Iiwibmlja25hbWUiOiJkcmVhbSIsImF2YXRhciI6IjEuanBnIn0.kQL0Oypr0-cqcotY8s_uMw-xQpH9YO4F_VGjB5p9_ts";
        Jws<Claims> claimsJws = Jwts.parser().setSigningKey(tokenSignKey).parseClaimsJws(token);

        Claims claims = claimsJws.getBody();

        String subject = claims.getSubject();
        String issuer = claims.getIssuer();
        String audience = claims.getAudience();
        Date issuedAt = claims.getIssuedAt();
        Date expiration = claims.getExpiration();
        Date notBefore = claims.getNotBefore();
        String id = claims.getId();

        System.out.println(subject);
        System.out.println(issuer);
        System.out.println(audience);
        System.out.println(issuedAt);
        System.out.println(expiration);
        System.out.println(notBefore);
        System.out.println(id);;

        String nickname = (String)claims.get("nickname");
        String avatar = (String)claims.get("avatar");

        System.out.println(nickname);
        System.out.println(avatar);
    }
}