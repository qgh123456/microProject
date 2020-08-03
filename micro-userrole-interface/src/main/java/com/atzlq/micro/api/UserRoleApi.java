package com.atzlq.micro.api;

import com.atzlq.micro.vo.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public interface UserRoleApi {

    @GetMapping("/userrole/getUserRoleById/{userId}/{roleId}")
    Result getUserRoleById(@PathVariable(value = "userId") Integer userId, @PathVariable(value = "roleId") Integer roleId);

}
