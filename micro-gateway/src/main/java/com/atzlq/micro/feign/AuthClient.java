package com.atzlq.micro.feign;

import com.atzlq.micro.auth.api.AuthApi;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("micro-service-auth")
public interface AuthClient extends AuthApi {
}
