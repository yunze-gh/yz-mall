package com.yz.mall.sys.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yz.mall.sys.dto.SysUserRelationOrgAddDto;
import com.yz.mall.sys.dto.SysUserRelationOrgQueryDto;
import com.yz.mall.sys.dto.SysUserRelationOrgUpdateDto;
import com.yz.mall.sys.entity.SysUserRelationOrg;
import com.yz.tools.PageFilter;

import javax.validation.Valid;

/**
 * 系统-用户关联组织数据表(SysUserRelationOrg)表服务接口
 *
 * @author yunze
 * @since 2024-11-17 20:26:16
 */
public interface SysUserRelationOrgService extends IService<SysUserRelationOrg> {

    /**
     * 新增数据
     *
     * @param dto 新增基础数据
     * @return 主键Id
     */
    Long save(SysUserRelationOrgAddDto dto);

    /**
     * 更新数据
     *
     * @param dto 更新基础数据
     * @return 是否操作成功
     */
    boolean update(@Valid SysUserRelationOrgUpdateDto dto);

    /**
     * 分页查询
     *
     * @param filter 过滤条件
     * @return 分页列表数据
     */
    Page<SysUserRelationOrg> page(PageFilter<SysUserRelationOrgQueryDto> filter);

}
