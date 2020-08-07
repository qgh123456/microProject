package com.atzlq.micro.auth.api;

import com.atzlq.micro.auth.vo.UserVo;
import com.atzlq.micro.common.core.vo.Result;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface AuthApi {

    @PostMapping("/auth/login")
    Result login(@RequestBody UserVo userVo);
}
