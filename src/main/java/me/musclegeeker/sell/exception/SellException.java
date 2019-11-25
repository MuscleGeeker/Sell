package me.musclegeeker.sell.exception;

import lombok.Setter;
import me.musclegeeker.sell.enums.ResultEnum;

@Setter
public class SellException extends RuntimeException {


    public SellException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
    }
}
