package com.yz.mall.sys.dto;

import java.time.LocalDateTime;

import com.yz.mall.sys.entity.SysMenu;
import com.yz.mall.sys.entity.SysRole;
import lombok.Data;

import java.io.Serializable;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * 系统-角色关联菜单表(SysRoleRelationMenu)表新增数据模型类
 *
 * @author yunze
 * @since 2024-11-28 12:58:05
 */
@Data
public class SysRoleRelationMenuAddDto implements Serializable {

    private static final long serialVesionUID = 1L;

    /**
     * 角色Id {@link SysRole#getId()}
     */
    @NotNull(message = "角色Id不能为空")
    private Long roleId;

    /**
     * 菜单Id {@link SysMenu#getId()}
     */
    @NotNull(message = "菜单Id不能为空")
    private Long menuId;


}

