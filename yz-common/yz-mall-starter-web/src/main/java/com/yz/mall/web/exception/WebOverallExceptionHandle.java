package com.yz.mall.web.exception;

import com.yz.mall.web.common.Result;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


/**
 * 全局异常捕获
 *
 * @author yunze
 * @date 2024/6/19 星期三 22:57
 */
@Order(1)
@RestControllerAdvice
public class WebOverallExceptionHandle {

    /**
     * 业务异常问题处理
     */
    @ExceptionHandler(RepeatSubmitException.class)
    Result<?> businessExceptionHandle(RepeatSubmitException e) {
        return Result.error(e.getMessage());
    }

}