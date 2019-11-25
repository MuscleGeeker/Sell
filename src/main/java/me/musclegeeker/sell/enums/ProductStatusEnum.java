package me.musclegeeker.sell.enums;

import lombok.Getter;

/**
 * 商品状态枚举
 */
@Getter
public enum ProductStatusEnum {
    /**
     * 在架商品
     */
    UP(0),
    /**
     * 下架商品
     */
    DOWN(1);

    private Integer code;

    ProductStatusEnum(Integer code) {
        this.code = code;
    }
}
