package com.yz.mall.pms.feign;

import com.yz.mall.pms.dto.InternalPmsStockDto;
import com.yz.tools.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @author yunze
 * @date 2024/6/23 16:26
 */
@Repository
@FeignClient(name = "yz-mall-pms", contextId = "internalStock")
public interface InternalPmsStockFeign {

    /**
     * 扣减商品库存
     */
    @PostMapping("internal/pms/stock/deduct")
    public Result<Boolean> deduct(@RequestBody @Valid InternalPmsStockDto dto);

    /**
     * 扣减商品库存
     */
    @PostMapping("internal/pms/stock/deductBatch")
    public Result<Boolean> deductBatch(@RequestBody @Valid List<InternalPmsStockDto> dto);

    /**
     * 增加商品库存
     */
    @PostMapping("internal/pms/stock/add")
    public Result<Boolean> add(@RequestBody @Valid InternalPmsStockDto dto);

    /**
     * 获取指定商品的库存
     */
    @GetMapping("internal/pms/stock/get/{productId}")
    public Result<Integer> getStockByProductId(@PathVariable String productId);
}
