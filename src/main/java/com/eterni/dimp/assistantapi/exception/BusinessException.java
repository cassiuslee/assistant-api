package com.eterni.dimp.assistantapi.exception;

import com.eterni.dimp.assistantapi.common.ResultCode;
import lombok.Getter;

/**
 * @author cqkir
 */
@Getter
public class BusinessException extends RuntimeException {

    private final Integer code;
    private final String message;

    public BusinessException(String message) {
        super(message);
        this.code = ResultCode.FAIL.getCode();
        this.message = message;
    }

    public BusinessException(Integer code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }

    public BusinessException(ResultCode resultCode) {
        super(resultCode.getMessage());
        this.code = resultCode.getCode();
        this.message = resultCode.getMessage();
    }

    @Override
    public String getMessage() {
        return message;
    }
}