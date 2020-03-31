package com.nefu.carbage.scheduled;

import com.nefu.carbage.entity.City;
import com.nefu.carbage.entity.Dicti;
import com.nefu.carbage.entity.Street;
import com.nefu.carbage.mapper.CityMapper;
import com.nefu.carbage.mapper.StreetMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Random;

/**
 * @program: carbage
 * @description:
 * @author: nefulan
 * @create: 2020-03-26 15:33
 **/
@Component
public class MyScheduled {
    private static final String[] cities = {"哈尔滨市", "上海市", "北京市"};
    private static final String[] streets = {"和兴路", "中央大街", "和平路"};

    @Autowired
    CityMapper cityMapper;
    @Autowired
    StreetMapper streetMapper;


    @Scheduled(cron = "0/10 * * * * ?")
    @Transactional
    public void insertSql() {
        for (int i = 0; i < 3; i++) {
            City city = new City();
            city.setCityName(cities[i]);
            city.setCreateDate(new Date());
            city.setHarmfulWaster(BigDecimal.valueOf(Math.random() * 1000));
            city.setRecyclable(BigDecimal.valueOf(Math.random() * 1000));
            city.setKitchenWaster(BigDecimal.valueOf(Math.random() * 1000));
            city.setOtherWaster(BigDecimal.valueOf(Math.random() * 1000));
            city.setGarbageSum(city.getRecyclable().add(city.getKitchenWaster().add(city.getOtherWaster().add(city.getHarmfulWaster()))));
            city.setRecycleSum(city.getGarbageSum().multiply(BigDecimal.valueOf(Math.random())));

            cityMapper.insert(city);
        }

        for (int i = 0; i < 3; i++) {
            Street street = new Street();
            street.setStreetName(streets[i]);
            street.setCreateDate(new Date());
            street.setHarmfulWaster(BigDecimal.valueOf(Math.random() * 1000));
            street.setRecyclable(BigDecimal.valueOf(Math.random() * 1000));
            //ll
            street.setKitchenWaster(BigDecimal.valueOf(Math.random() * 1000));
            street.setOtherWaster(BigDecimal.valueOf(Math.random() * 1000));
            street.setGarbageSum(street.getRecyclable().add(street.getKitchenWaster().add(street.getOtherWaster().add(street.getHarmfulWaster()))));
            street.setRecycleSum(street.getGarbageSum().multiply(BigDecimal.valueOf(Math.random())));
            street.setCityId(1); //哈尔滨市
            streetMapper.insert(street);
        }
    }

}
