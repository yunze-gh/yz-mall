package com.yz.mall.pms.vo;

import com.yz.mall.pms.entity.PmsProduct;
import lombok.Data;

/**
 * 商品信息
 *
 * @author yunze
 * @since 2024-12-20 13:08:05
 */
@Data
public class PmsProductSlimVo {

    /**
     * 主键标识
     */
    private Long id;

    /**
     * 商品名称
     */
    private String name;

    /**
     * 商品标签
     */
    private String titles;

    /**
     * 商品图片id，限制为5张，以逗号分割
     */
    private String albumPics;

    public PmsProductSlimVo(PmsProduct bo) {
        this.id = bo.getId();
        this.name = bo.getName();
        this.titles = bo.getTitles();
        this.albumPics = bo.getAlbumPics();
    }

    public PmsProductSlimVo() {}
}

