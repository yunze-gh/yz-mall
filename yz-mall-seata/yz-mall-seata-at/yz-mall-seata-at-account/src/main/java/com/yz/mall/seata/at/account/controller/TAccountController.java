package com.yz.mall.seata.at.account.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yz.mall.seata.at.account.entity.TAccount;
import com.yz.mall.seata.at.account.service.TAccountService;
import com.yz.tools.ApiController;
import com.yz.tools.PageFilter;
import com.yz.tools.Result;
import com.yz.tools.TableResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * 账号信息(TAccount)表控制层
 *
 * @author yunze
 * @since 2023-11-07 23:21:27
 */
@RestController
@RequestMapping("account")
public class TAccountController extends ApiController {

    /**
     * 服务对象
     */
    @Autowired
    private TAccountService tAccountService;

    /**
     * 分页查询所有数据
     *
     * @param filter 分页查询过滤条件
     * @return 所有数据
     */
    @PostMapping("/page")
    public TableResult<List<TAccount>> page(@RequestBody @Validated PageFilter<TAccount> filter) {
        Page<TAccount> page = this.tAccountService.page(new Page<>(filter.getCurrent(), filter.getSize()), new QueryWrapper<>(filter.getFilter()));
        return success(page.getRecords(), page.getTotal());
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/get/{id}")
    public Result<TAccount> selectOne(@PathVariable Serializable id) {
        return success(this.tAccountService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param tAccount 实体对象
     * @return 新增结果
     */
    @PostMapping("/add")
    public Result<Boolean> insert(@RequestBody @Validated TAccount tAccount) {
        return success(this.tAccountService.save(tAccount));
    }

    /**
     * 修改数据
     *
     * @param tAccount 实体对象
     * @return 修改结果
     */
    @PostMapping("/update")
    public Result<Boolean> update(@RequestBody @Validated TAccount tAccount) {
        return success(this.tAccountService.updateById(tAccount));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除结果
     */
    @PostMapping("/delete/{id}")
    public Result<Boolean> delete(@PathVariable Long id) {
        return success(this.tAccountService.removeById(id));
    }


    /**
     * 扣减余额
     *
     * @param accountId 账号ID
     * @param amount    扣减金额
     */
    @RequestMapping("/deduct")
    public Result<Boolean> deduct(@RequestParam("accountId") Long accountId, @RequestParam("amountToDeduct") BigDecimal amountToDeduct) {
        boolean deduct = this.tAccountService.deduct(accountId, amountToDeduct);
        return deduct ? success(true) : failed("余额扣减失败");
    }
}
