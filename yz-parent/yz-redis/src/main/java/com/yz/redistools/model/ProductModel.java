package com.yz.redistools.model;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author : yunze
 * @date : 2023/9/19 12:51
 */
@Data
public class ProductModel {

    /**
     * 商品ID
     */
    private Long id;

    /**
     * 商品名称
     */
    private String name;

    /**
     * 价格
     */
    private BigDecimal price;

    /**
     * 库存
     */
    private Integer stock;
}