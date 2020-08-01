package com.atzlq.micro.role.feign;

import com.atzlq.micro.common.vo.Result;
import com.atzlq.micro.userrole.api.UserRoleApi;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @ProjectName: micro-project
 * @Description:
 * @Author: qiguohui
 * @Date: 2020/8/1 15:49
 */
@FeignClient("micro-service-userRole")
public interface UserRoleClient extends UserRoleApi {

//    @GetMapping("/userrole/getUserRoleById/{userId}/{roleId}")
//    Result getUserRoleById(@PathVariable(value = "userId") Integer userId,@PathVariable(value = "roleId") Integer roleId);
}
