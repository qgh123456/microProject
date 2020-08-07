package com.atzlq.micro.config;

import com.atzlq.micro.common.cache.util.RedisUtil;
import com.atzlq.micro.common.core.util.JwtUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.RequestPath;
import org.springframework.util.CollectionUtils;
import com.atzlq.micro.feign.AuthClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;
import org.springframework.http.HttpCookie;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @ProjectName: micro-project
 * @Description:
 * @Author: qiguohui
 * @Date: 2020/8/4 11:11
 */
@Component
public class AuthGatewayFilter implements GatewayFilter {

    @Autowired
    private AuthClient authClient;

    @Autowired
    private RedisUtil redisUtil;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

        // 获取request和response，注意：不是HttpServletRequest及HttpServletResponse
        ServerHttpRequest request = exchange.getRequest();
        ServerHttpResponse response = exchange.getResponse();
        // 获取所有cookie
        MultiValueMap<String, HttpCookie> cookies = request.getCookies();
        // 如果cookies为空或者不包含指定的token，则相应认证未通过
        if (CollectionUtils.isEmpty(cookies) || !cookies.containsKey("token")) {
            // 响应未认证！
            response.setStatusCode(HttpStatus.UNAUTHORIZED);
            // 结束请求
            return response.setComplete();
        }
        HttpHeaders headers = request.getHeaders();
        String token = headers.getFirst("Authorization");
        try {
            // 校验authorization
            JwtUtil.verify(token);
            // 获取请求的路径
            RequestPath path = request.getPath();
            // 解析token,获取里面的account
            String account = JwtUtil.getClaim(token, "account");
            // 刷新token的过期时间
            // 获取tokenId
            String tokenId = JwtUtil.getClaim(token, "tokenId");
            // 放入到redis中，用于判断
            redisUtil.expire(tokenId,600);
            Map<Object, Object> userDetail = redisUtil.hmget(tokenId);
            // ToDo 获取权限，找到里面的路径，用于判断该访问是否具备权限

        } catch (Exception e) {
            e.printStackTrace();
            // 校验失败，响应未认证
            response.setStatusCode(HttpStatus.UNAUTHORIZED);
            return response.setComplete();
        }

        // 认证通过放行
        return chain.filter(exchange);

    }
}
