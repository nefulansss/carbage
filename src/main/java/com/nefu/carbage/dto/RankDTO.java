package com.nefu.carbage.dto;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @program: carbage
 * @description:
 * @author: nefulan
 * @create: 2020-03-26 12:00
 **/
@Data
public class RankDTO {

    private int num;
    private String name;
    private BigDecimal CarbageSum;
    private BigDecimal CompletionRate;
}
