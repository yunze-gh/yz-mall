package com.yz.mall.sys.service.impl;

import com.yz.mall.sys.dto.InternalRolePermissionQueryDto;
import com.yz.mall.sys.feign.InternalSysRoleRelationMenuFeign;
import com.yz.mall.sys.service.InternalSysRoleRelationMenuService;
import com.yz.mall.web.common.Result;
import com.yz.mall.web.enums.CodeEnum;
import com.yz.mall.web.exception.FeignException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 内部暴露service实现类: 角色关联菜单
 *
 * @author yunze
 * @date 2024/12/9 19:42
 */
@Service
public class InternalSysRoleRelationMenuServiceImpl implements InternalSysRoleRelationMenuService {

    private final InternalSysRoleRelationMenuFeign feign;

    public InternalSysRoleRelationMenuServiceImpl(InternalSysRoleRelationMenuFeign feign) {
        this.feign = feign;
    }

    @Override
    public Map<String, List<String>> getPermissionsByRoleIds(InternalRolePermissionQueryDto query) {
        Result<Map<String, List<String>>> result = feign.getPermissionsByRoleIds(query);
        if (!CodeEnum.SUCCESS.get().equals(result.getCode())) {
            throw new FeignException(result.getCode(), result.getMsg());
        }
        return result.getData();
    }
}
