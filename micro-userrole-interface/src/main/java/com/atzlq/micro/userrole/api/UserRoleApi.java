package com.atzlq.micro.userrole.api;

import com.atzlq.micro.common.vo.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public interface UserRoleApi {

    @GetMapping("/userrole/getUserRoleById/{userId}/{roleId}")
    Result getUserRoleById(@PathVariable(value = "userId") Integer userId, @PathVariable(value = "roleId") Integer roleId);

}
