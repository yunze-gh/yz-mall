package com.yz.mall.sys.dto;

import com.yz.mall.sys.entity.SysOrg;
import com.yz.mall.sys.entity.SysRole;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

/**
 * 用户信息查询过滤条件数据模型类
 *
 * @author yunze
 * @since 2024-06-16 23:25:56
 */
@Data
public class SysUserQueryDto implements Serializable {

    private static final long serialVesionUID = 1L;

    /**
     * 创建时间
     */
    private LocalDateTime createdTime;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 用户Id
     */
    private List<Long> userIds;

    /**
     * 组织Id {@link SysOrg#getId()}
     */
    private Long orgId;

    /**
     * 角色Id {@link SysRole#getId()}
     */
    private Long roleId;
}

