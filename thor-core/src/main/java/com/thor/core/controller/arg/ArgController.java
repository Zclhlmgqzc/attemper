package com.thor.core.controller.arg;

import com.thor.core.service.arg.ArgService;
import com.thor.sdk.common.constant.ThorAPIConst;
import com.thor.sdk.common.constant.ThorAPIPath;
import com.thor.sdk.common.param.arg.ArgGetParam;
import com.thor.sdk.common.param.arg.ArgListParam;
import com.thor.sdk.common.param.arg.ArgRemoveParam;
import com.thor.sdk.common.param.arg.ArgSaveParam;
import com.thor.sdk.common.result.CommonResult;
import com.thor.sdk.common.result.arg.Arg;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class ArgController {
    @Autowired
    private ArgService argService;


    @ApiOperation(ThorAPIConst.Operation.Arg.ADD)
    @ApiImplicitParam(value = "被新增的数据", name = "saveParam", dataType = "ArgSaveParam", required = true)
    @PostMapping(value = ThorAPIPath.Arg.ADD)
    public CommonResult<Arg> add(@RequestBody ArgSaveParam saveParam) {
        return CommonResult.putResult(argService.add(saveParam));
    }

    @ApiOperation(ThorAPIConst.Operation.Arg.GET)
    @ApiImplicitParam(value = "查询单个参数信息", name = "getParam", dataType = "ArgGetParam", required = true)
    @GetMapping(value = ThorAPIPath.Arg.GET)
    public CommonResult<Arg> get(ArgGetParam getParam) {
        return CommonResult.putResult(argService.get(getParam));
    }

    @ApiOperation(ThorAPIConst.Operation.Arg.LIST)
    @ApiImplicitParam(value = "查询参数", name = "listParam", dataType = "ArgListParam", required = true)
    @GetMapping(ThorAPIPath.Arg.LIST)
    public CommonResult<Map<String, Object>> list(ArgListParam listParam) {
        return CommonResult.putResult(argService.list(listParam));
    }

    @ApiOperation(ThorAPIConst.Operation.Arg.UPDATE)
    @ApiImplicitParam(value = "被更新的参数", name = "saveParam", dataType = "ArgSaveParam", required = true)
    @PutMapping(value = ThorAPIPath.Arg.UPDATE)
    public CommonResult<Arg> update(@RequestBody ArgSaveParam saveParam) {
        return CommonResult.putResult(argService.update(saveParam));
    }

    @ApiOperation(ThorAPIConst.Operation.Arg.REMOVE)
    @ApiImplicitParam(value = "被删除的主键数组", name = "removeParam", dataType = "ArgRemoveParam", required = true)
    @DeleteMapping(value = ThorAPIPath.Arg.REMOVE)
    public CommonResult remove(@RequestBody ArgRemoveParam removeParam) {
        argService.remove(removeParam);
        return CommonResult.ok();
    }

}
