package com.eterni.dimp.assistantapi.exception;

import com.eterni.dimp.assistantapi.common.ApiResult;
import com.eterni.dimp.assistantapi.common.ResultCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * 业务异常
     */
    @ExceptionHandler(BusinessException.class)
    public ApiResult<Void> handleBusinessException(BusinessException e) {
        log.warn("业务异常: {}", e.getMessage());
        return ApiResult.fail(e.getCode(), e.getMessage());
    }

    /**
     * 非法参数异常
     */
    @ExceptionHandler(IllegalArgumentException.class)
    public ApiResult<Void> handleIllegalArgumentException(IllegalArgumentException e) {
        log.warn("参数异常: {}", e.getMessage());
        return ApiResult.fail(ResultCode.BAD_REQUEST.getCode(), e.getMessage());
    }

    /**
     * 运行时异常
     */
    @ExceptionHandler(RuntimeException.class)
    public ApiResult<Void> handleRuntimeException(RuntimeException e) {
        log.error("运行时异常: ", e);
        return ApiResult.fail("运行时异常：" + e.getMessage());
    }

    /**
     * 兜底异常
     */
    @ExceptionHandler(Exception.class)
    public ApiResult<Void> handleException(Exception e) {
        log.error("系统异常: ", e);
        return ApiResult.fail(ResultCode.FAIL.getCode(), "系统异常，请联系管理员");
    }
}