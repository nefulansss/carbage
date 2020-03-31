package com.nefu.carbage.dto;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @program: carbage
 * @description:
 * @author: nefulan
 * @create: 2020-03-25 23:26
 **/
@Data
public class PieChartDTO{



    private String Name;

    private BigDecimal recyclable;

    private BigDecimal otherWaster;

    private BigDecimal kitchenWaster;

    private BigDecimal harmfulWaster;





}
