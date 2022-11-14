package com.yz.auth.baseClient.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gh.auth.baseClient.entity.BaseClient;
import com.gh.auth.baseClient.mapper.BaseClientMapper;
import com.gh.auth.baseClient.service.BaseClientService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 基础-客户端表 服务实现类
 * </p>
 *
 * @author gaohan
 * @since 2022-10-07
 */
@Service
public class BaseClientServiceImpl extends ServiceImpl<BaseClientMapper, BaseClient> implements BaseClientService {

    @Override
    public BaseClient getClientByClientId(String clientId) {
        LambdaQueryWrapper<BaseClient> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(BaseClient::getClientId, clientId);
        queryWrapper.last(" limit 1");
        return baseMapper.selectOne(queryWrapper);
    }
}
