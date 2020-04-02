package com.nefu.carbage.controller;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Maps;
import com.nefu.carbage.dto.PieChartDTO;
import com.nefu.carbage.dto.RankDTO;
import com.nefu.carbage.dto.StreetDTO;
import com.nefu.carbage.entity.City;
import com.nefu.carbage.entity.Street;
import com.nefu.carbage.service.CarbageService;
import com.nefu.carbage.util.JsonResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

/**
 * @program: carbage
 * @description:
 * @author: nefulan
 * @create: 2020-03-25 22:40
 **/
@RestController
//@CrossOrigin
public class CarbageController {
    private static final Logger LOGGER = LoggerFactory.getLogger(CarbageController.class);

    @Autowired
    CarbageService carbageService;



//    /**
//     * 获取首页数据  街道信息
//     */
//    @RequestMapping("index")
//    public JsonResult getStreetToday( String city, String street){
//        LOGGER.info("index：：{}  {}",city,street);
//        Street streetToday = carbageService.getStreetToday(city,street);
//
//        if (streetToday!=null){
//            return new JsonResult(streetToday,"返回成功",200);
//        }else {
//            return new JsonResult(null,"返回失败",200);
//        }
//    }


    /**
     * 获取首页数据  街道信息
     */
    @RequestMapping("index")
    public JsonResult getStreetToday(){
        LOGGER.info("index：");
        List<StreetDTO> streetToday = carbageService.getStreetToday();
        LOGGER.info("index数据：{}",JSON.toJSONString(streetToday));
        if (streetToday!=null){
            return new JsonResult(streetToday,"返回成功",200);
        }else {
            return new JsonResult(null,"返回失败",200);
        }
    }

    /**
     * 街道饼状图
     * @param city
     * @param street
     * @return
     */
    @RequestMapping("getPieChartStreet")
    public JsonResult getPieChartStreet(String city, String street){
        Street streetToday = carbageService.getPieChartStreet(city,street);
        if (streetToday!=null){
            PieChartDTO pieChartDTO = new PieChartDTO();
            pieChartDTO.setName(streetToday.getStreetName());
            pieChartDTO.setRecyclable(streetToday.getRecyclable().divide(streetToday.getGarbageSum(),4, BigDecimal.ROUND_HALF_UP));
            pieChartDTO.setOtherWaster(streetToday.getOtherWaster().divide(streetToday.getGarbageSum(),4, BigDecimal.ROUND_HALF_UP));
            pieChartDTO.setKitchenWaster(streetToday.getKitchenWaster().divide(streetToday.getGarbageSum(),4, BigDecimal.ROUND_HALF_UP));
            pieChartDTO.setHarmfulWaster(streetToday.getHarmfulWaster().divide(streetToday.getGarbageSum(),4, BigDecimal.ROUND_HALF_UP));
            return new JsonResult(pieChartDTO,"返回成功",200);
        }else {
            return new JsonResult(null,"返回失败",200);
        }

    }

    /**
     * 城区饼状图
     * @param city
     * @return
     */
    @RequestMapping("getPieChartCity")
    public JsonResult getPieChartCity( String city){
        LOGGER.info(city);

        City cityToday =carbageService.getPieChartCity(city);
        LOGGER.info("城区饼状图: {}", JSON.toJSONString(cityToday));
        if (cityToday!=null){
        PieChartDTO pieChartDTO = new PieChartDTO();
        pieChartDTO.setName(cityToday.getCityName());
        pieChartDTO.setRecyclable(cityToday.getRecyclable().divide(cityToday.getGarbageSum(),4, BigDecimal.ROUND_HALF_UP));
        pieChartDTO.setOtherWaster(cityToday.getOtherWaster().divide(cityToday.getGarbageSum(),4, BigDecimal.ROUND_HALF_UP));
        pieChartDTO.setKitchenWaster(cityToday.getKitchenWaster().divide(cityToday.getGarbageSum(),4, BigDecimal.ROUND_HALF_UP));
        pieChartDTO.setHarmfulWaster(cityToday.getHarmfulWaster().divide(cityToday.getGarbageSum(),4, BigDecimal.ROUND_HALF_UP));
        return new JsonResult(pieChartDTO,"返回成功",200);
    }else {
        return new JsonResult(null,"返回失败",200);
    }
    }

    /**
     * 市级最近七天数据
     * @return
     */
    @RequestMapping("getCurrentCity7Days")
    public JsonResult getCurrentCity7Days(String city){
        List<City> list = carbageService.getCurrentCity7Days(city);
        if (list!=null){
            Map<String, BigDecimal> map = Maps.newHashMap();
/*

            for (int i=0;i<7;i++){
                map.put(i+"",list.get(i).getGarbageSum());
            }
*/
            LOGGER.info("近七天全部数据：：{}",JSON.toJSONString(list));
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            for (City cityCageSum : list) {
                map.put(sdf.format(cityCageSum.getCreateDate()),cityCageSum.getGarbageSum());
            }


            return new JsonResult(map,"返回成功",200);

        }else {
            return new JsonResult(null,"返回失败",200);
        }
    }

    /**
     * 最近30天的数据
     * @return
     */
    @RequestMapping("getCurrent30Days")
    public JsonResult getCurrent30DaysCountry(){
        Map<String,BigDecimal> map = carbageService.getCurrent30DaysCountry();
        if (map!=null){
            return new JsonResult(map,"返回成功",200);
        }else {
            return new JsonResult(null,"返回失败",200);
        }
    }
    /**
     * 城市垃圾排名 top3
     */
    @RequestMapping("getCityRank")
    public JsonResult getCityRank(){
        List<RankDTO> list = carbageService.getCityRank();
        if (list!=null){
            return new JsonResult(list,"返回成功",200);
        }else {
            return new JsonResult(null,"返回失败",200);
        }
    }

    /**
     * 街道垃圾排名  top3
     */
    @RequestMapping("getStreetRank")
    public JsonResult getStreetRank(){
        List<RankDTO> list = carbageService.getStreetRank();
        if (list!=null){
            return new JsonResult(list,"返回成功",200);
        }else {
            return new JsonResult(null,"返回失败",200);
        }
    }



}
