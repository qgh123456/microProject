package com.atzlq.micro.user.api;

import com.atzlq.micro.common.vo.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public interface UserApi {

    @GetMapping("/user/getUserById/{userId}")
    Result getUserById(@PathVariable(value = "userId") Integer userId);

}
