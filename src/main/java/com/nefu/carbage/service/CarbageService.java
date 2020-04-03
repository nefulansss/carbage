package com.nefu.carbage.service;

import com.nefu.carbage.dto.RankDTO;
import com.nefu.carbage.dto.StreetDTO;
import com.nefu.carbage.entity.City;
import com.nefu.carbage.entity.Street;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * @program: carbage
 * @description:
 * @author: nefulan
 * @create: 2020-03-25 22:40
 **/
public interface CarbageService {


    Street getStreetToday(String city, String street);

   Map<String,Object> getStreetToday();

    City getPieChartCity(String city);

    List<City> getCurrentCity7Days(String city);

    Map<String, BigDecimal> getCurrent30DaysCountry();

    List<RankDTO> getCityRank();

    List<RankDTO> getStreetRank();

    Street getPieChartStreet(String city, String street);
}
