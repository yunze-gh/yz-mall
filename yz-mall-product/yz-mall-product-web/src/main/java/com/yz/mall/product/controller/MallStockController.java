package com.yz.mall.product.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yz.mall.product.dto.MallStockDto;
import com.yz.mall.product.dto.MallStockQueryDto;
import com.yz.mall.product.entity.MallStock;
import com.yz.mall.product.service.MallStockService;
import com.yz.tools.ApiController;
import com.yz.tools.PageFilter;
import com.yz.tools.Result;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

/**
 * 商品库存表(MallStock)表控制层
 *
 * @author yunze
 * @since 2024-06-16 16:14:09
 */
@RestController
@RequestMapping("mall/stock")
public class MallStockController extends ApiController {

    /**
     * 服务对象
     */
    @Resource
    private MallStockService service;

    /**
     * 分页查询
     */
    @PostMapping("page")
    public Result<List<MallStock>> page(@RequestBody @Valid PageFilter<MallStockQueryDto> filter) {
        Page<MallStock> page = this.service.page(filter);
        return success(page.getRecords(), page.getTotal());
    }

    /**
     * 详情查询
     */
    @GetMapping("get/{id}")
    public Result<MallStock> page(@PathVariable String id) {
        return success(this.service.getById(id));
    }

    /**
     * 扣减商品库存
     */
    @PostMapping("deduct")
    public Result<Boolean> deduct(@RequestBody @Valid MallStockDto dto) {
        return success(this.service.deduct(dto.getProductId(), dto.getQuantity()));
    }

    /**
     * 增加商品库存
     */
    @PostMapping("add")
    public Result<Boolean> add(@RequestBody @Valid MallStockDto dto) {
        return success(this.service.add(dto.getProductId(), dto.getQuantity()));
    }
}
