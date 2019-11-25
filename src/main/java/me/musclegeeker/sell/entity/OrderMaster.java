package me.musclegeeker.sell.entity;

import lombok.Data;
import me.musclegeeker.sell.enums.OrderStatusEnum;
import me.musclegeeker.sell.enums.PayStatusEnum;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Entity
public class OrderMaster {

    @Id
    private String orderId;

    private String buyerName;

    private String buyerPhone;

    private String buyerAddress;

    private String buyerOpenid;

    private BigDecimal orderAmount;

    private Integer orderStatus = OrderStatusEnum.NEW.getCode();

    private Integer payStatus = PayStatusEnum.UNPAID.getCode();

    private Date createTime;

    private Date updateTime;
}
