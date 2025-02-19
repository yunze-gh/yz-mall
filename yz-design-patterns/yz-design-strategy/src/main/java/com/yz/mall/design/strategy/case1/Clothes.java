package com.yz.mall.design.strategy.case1;

/**
 * 衣服
 * @author yunze
 * @date 2024/1/22 12:49
 */
public interface Clothes {

    /*public void print() {
        System.out.println("---------衣服属性---------");
        System.out.println("衣服类型：");
        this.type();
        System.out.println("衣服功能：");
        this.function();
    }*/

    /**
     * 衣服类型
     */
    void type();

    /**
     * 衣服功能
     */
    void function();
}
