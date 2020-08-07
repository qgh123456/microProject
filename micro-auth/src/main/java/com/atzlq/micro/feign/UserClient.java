package com.atzlq.micro.feign;

import com.atzlq.micro.api.UserApi;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("micro-service-user")
public interface UserClient extends UserApi {


}
