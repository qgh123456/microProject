package com.atzlq.micro.api;

import com.atzlq.micro.common.core.vo.Result;
import com.atzlq.micro.entity.UserEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public interface UserApi {

    @GetMapping("/user/getUserById/{userId}")
    Result getUserById(@PathVariable(value = "userId") Integer userId);

    @GetMapping("/getUser")
    Result getUser(String account);
}
