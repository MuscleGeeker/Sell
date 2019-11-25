package me.musclegeeker.sell.common.result;

import lombok.Data;

@Data
public class ResultVO<T> {

    private Integer code;

    private Boolean success;

    private String message;

    private T data;
}
