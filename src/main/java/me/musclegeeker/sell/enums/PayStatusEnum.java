package me.musclegeeker.sell.enums;

import lombok.Getter;

@Getter
public enum PayStatusEnum {

    UNPAID(0, "待支付"),

    PAID(1, "已支付"),
    ;

    private Integer code;

    private String desc;

    PayStatusEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}
