package com.nefu.carbage.dto;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @Author: zhanglan61
 * @Date: 2020/4/2 10:42
 * @Version: 1.0
 */
@Data
public class City30DTO implements Serializable {


    private String divideTime;

    private BigDecimal garbageSum;
}
