package com.thor.security.controller;

import com.thor.sdk.common.constant.ThorAPIConst;
import com.thor.sdk.common.constant.ThorAPIPath;
import com.thor.sdk.common.param.login.LoginParam;
import com.thor.sdk.common.result.CommonResult;
import com.thor.sdk.common.result.login.LoginResult;
import com.thor.security.service.LoginService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = ThorAPIConst.Tag.LOGIN)
@RestController
public class LoginController {

    private @Autowired
    LoginService service;

    @ApiOperation(ThorAPIConst.Operation.Login.LOGIN)
    @ApiImplicitParam(value = "登录的用户", name = "loginParam", dataType = "LoginParam", required = true)
    @PostMapping(ThorAPIPath.Login.LOGIN_BY_USERNAME_PWD)
    public CommonResult<LoginResult> login(@RequestBody LoginParam loginParam) {
        return CommonResult.putResult(service.login(loginParam));
    }

}
