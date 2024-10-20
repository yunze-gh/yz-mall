package com.yz.tools.enums;

/**
 * @ClassName CodeEnum
 * @Description 异常信息编码
 * @Author yunze
 * @Date 2022/11/13 23:23
 * @Version 1.0
 */
public enum CodeEnum {
    /**
     * 成功
     */
    SUCCESS(0),
    /**
     * 业务异常
     */
    BUSINESS_ERROR(1),
    /**
     * 权限异常
     */
    AUTHENTICATION_ERROR(2),
    /**
     * 非法token
     */
    ERROR_TOKEN_ILLEGAL(50008),
    /**
     * token已经过期
     */
    ERROR_TOKEN_EXPIRED(50014),
    /**
     * 系统异常
     */
    SYSTEM_ERROR(3),
    /**
     * 参数异常
     */
    PARAMS_ERROR(5),
    /**
     * 格式化异常
     */
    FORMAT_ERROR(6),
    /**
     * 其他异常
     */
    OTHER_ERROR(9);

    private Integer value;

    CodeEnum(Integer value) {
        this.value = value;
    }

    public Integer get() {
        return this.value;
    }
}
