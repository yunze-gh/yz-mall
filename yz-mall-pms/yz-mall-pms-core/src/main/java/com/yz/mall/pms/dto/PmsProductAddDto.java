package com.yz.mall.pms.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 商品表(PmsProduct)表新增数据模型类
 *
 * @author yunze
 * @since 2024-06-16 16:06:43
 */
@Data
public class PmsProductAddDto implements Serializable {

    private static final long serialVesionUID = 1L;

    /**
     * 商品名称
     */
    @NotBlank(message = "商品名称不能为空")
    private String name;

    /**
     * 商品价格
     */
    @NotNull(message = "商品价格不能为空")
    private BigDecimal price;

    /**
     * 商品标签
     */
    private String title;

    /**
     * 商品备注信息
     */
    private String remark;

    /**
     * 商品上架状态：0：下架，1：上架
     */
    private Integer publishStatus;

    /**
     * 商品审核状态：0：未审核，1：审核通过
     */
    private Integer verifyStatus;

    /**
     * 商品图片id，限制为5张，以逗号分割
     */
    private String albumPics;

}
