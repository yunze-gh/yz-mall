package com.yz.mall.design.factory.strategy;


import java.util.Map;

/**
 * 权限过滤
 *
 * @author yunze
 * @date 2024/1/20 15:05
 */
public interface AuthStrategy {

    /**
     * 设置过滤条件
     *
     * @param filter 过滤条件
     */
    void setFilterConditions(User user, Map<String, Object> filter);
}