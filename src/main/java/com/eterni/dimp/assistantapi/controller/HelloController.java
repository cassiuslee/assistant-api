package com.eterni.dimp.assistantapi.controller;

import com.eterni.dimp.assistantapi.common.ApiResult;
import com.eterni.dimp.assistantapi.exception.BusinessException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.Operation;

import java.util.HashMap;
import java.util.Map;

/**
 * @author cqkir
 */
@RestController
@RequestMapping("/test")
public class HelloController {
    @Operation(summary = "正常返回")
    @GetMapping("/hello")
    public ApiResult<String> hello() {
        return ApiResult.success("assistant-api 启动成功");
    }

    @Operation(summary = "业务异常示例")
    @GetMapping("/biz-error")
    public ApiResult<Void> bizError() {
        throw new BusinessException(500, "库存不足，无法下单");
    }

    @Operation(summary = "参数异常示例")
    @GetMapping("/arg-error")
    public ApiResult<Void> argError() {
        throw new IllegalArgumentException("用户ID不能为空");
    }

    @Operation(summary = "系统异常示例")
    @GetMapping("/sys-error")
    public ApiResult<Void> sysError() {
        int a = 1 / 0;
        return ApiResult.success();
    }
}
