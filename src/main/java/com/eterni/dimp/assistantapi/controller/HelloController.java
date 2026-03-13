package com.eterni.dimp.assistantapi.controller;

import com.eterni.dimp.assistantapi.common.ApiResult;
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
    @Operation(summary = "测试接口")
    @GetMapping("/hello")
    public String hello() {
        return "assistant-api started";
    }

    @GetMapping("/user")
    public ApiResult<Map<String, Object>> user() {
        Map<String, Object> data = new HashMap<>();
        data.put("id", 1);
        data.put("name", "Tom");
        data.put("role", "admin");
        return ApiResult.success(data);
    }

    @GetMapping("/error")
    public ApiResult<Void> error() {
        return ApiResult.fail("这是一个失败示例");
    }
}
