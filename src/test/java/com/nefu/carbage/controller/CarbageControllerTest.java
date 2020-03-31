package com.nefu.carbage.controller;

import com.alibaba.fastjson.JSON;
import com.nefu.carbage.CarbageApplication;
import com.nefu.carbage.util.JsonResult;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @program: carbage
 * @description:
 * @author: nefulan
 * @create: 2020-03-26 13:37
 **/
@SpringBootTest(classes = CarbageApplication.class)
@RunWith(SpringRunner.class)
public class CarbageControllerTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(CarbageController.class);

    @Autowired
    CarbageController carbageController;


    /**
     * 首页数据
     */
    @Test
    public void getStreetTodayTest(){
        JsonResult streetToday = carbageController.getStreetToday();
        LOGGER.info("首页数据： {}",JSON.toJSONString(streetToday));
        Assert.assertNotNull(streetToday);
    }

    /**
     * 饼状图  街道
     */
    @Test
    public void getPieChartStreetTest(){
        JsonResult streetToday = carbageController.getPieChartStreet("哈尔滨市", "和兴路");
        LOGGER.info("饼状图  街道： {}",JSON.toJSONString(streetToday));
        Assert.assertNotNull(streetToday);
    }

    /**
     * 饼状图  市区
     */
    @Test
    public void getPieChartCityTest(){
        JsonResult streetToday = carbageController.getPieChartCity("哈尔滨市");
        LOGGER.info("饼状图  市区： {}",JSON.toJSONString(streetToday));
        Assert.assertNotNull(streetToday);
    }

    /**
     * 市级最近七天数据
     * @return
     */
    @Test
    public void getCurrentCity7DaysTest(){
        JsonResult streetToday = carbageController.getCurrentCity7Days("哈尔滨市");
        LOGGER.info("市级最近七天数据： {}",JSON.toJSONString(streetToday));
        Assert.assertNotNull(streetToday);
    }
    /**
     * 最近30天的数据
     * @return
     */
    @Test
    public void getCurrent30DaysCountryTest(){
        JsonResult streetToday = carbageController.getCurrent30DaysCountry();
        LOGGER.info("最近30天的数据： {}",JSON.toJSONString(streetToday));
        Assert.assertNotNull(streetToday);
    }
    /**
     * 城市垃圾排名 top3
     */
    @Test
    public void getCityRankTest(){
        JsonResult streetToday = carbageController.getCityRank();
        LOGGER.info("城市垃圾排名 top3 ： {}",JSON.toJSONString(streetToday));
        Assert.assertNotNull(streetToday);
    }
    /**
     * 街道垃圾排名  top3
     */
    @Test
    public void getStreetRankTest(){
        JsonResult streetToday = carbageController.getStreetRank();
        LOGGER.info("街道垃圾排名  top3： {}",JSON.toJSONString(streetToday));
        Assert.assertNotNull(streetToday);
    }


}
