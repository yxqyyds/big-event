package org.example;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JwtTest {
    @Test
    public void testGen(){
        Map<String,Object> claims=new HashMap<>();
        claims.put("id",1);
        claims.put("username","张三");
        String token=JWT.create()
                .withClaim("user",claims)
                .withExpiresAt(new Date(System.currentTimeMillis()+1000*60*60*12))
                .sign(Algorithm.HMAC256("zut202320144311"));//指定算法配置密钥

        System.out.println(token);


    }

    @Test
    public void testParse(){
        String token="eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9" +
                ".eyJ1c2VyIjp7ImlkIjoxLCJ1c2VybmFtZSI6IuW8oOS4iSJ9LCJleHAiOjE3MjY3MTUzNDV9" +
                ".XuvRq9XJBzqOoE4TAXOEjjW2noD94rQNcW6hRdaDTIg";
        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256("zut202320144311")).build();
        DecodedJWT decodeJWT = jwtVerifier.verify(token);//验证token生成一个解析后的jwt的对象
        Map<String, Claim> claims = decodeJWT.getClaims();
        System.out.println(claims.get("user"));


    }
}
