package com.atzlq.micro.role.feign;

import com.atzlq.micro.user.api.UserApi;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("micro-service-user")
public interface UserClient extends UserApi {


}
