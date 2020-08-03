package com.atzlq.micro.feign;

import com.atzlq.micro.api.UserRoleApi;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @ProjectName: micro-project
 * @Description:
 * @Author: qiguohui
 * @Date: 2020/8/1 15:49
 */
@FeignClient("micro-service-userRole")
public interface UserRoleClient extends UserRoleApi {

}
