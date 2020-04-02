package com.nefu.carbage.service.impl;

import com.alibaba.fastjson.JSON;
import com.nefu.carbage.controller.CarbageController;
import com.nefu.carbage.dto.City30DTO;
import com.nefu.carbage.dto.RankDTO;
import com.nefu.carbage.dto.StreetDTO;
import com.nefu.carbage.entity.City;
import com.nefu.carbage.entity.Dicti;
import com.nefu.carbage.entity.Street;
import com.nefu.carbage.mapper.CityMapper;
import com.nefu.carbage.mapper.DictiMapper;
import com.nefu.carbage.mapper.StreetMapper;
import com.nefu.carbage.service.CarbageService;
import com.nefu.carbage.util.TimeUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @program: carbage
 * @description:
 * @author: nefulan
 * @create: 2020-03-25 22:41
 **/
@Service
public class CarbageImpl implements CarbageService {
    private static final Logger LOGGER = LoggerFactory.getLogger(CarbageController.class);

    @Resource
    CityMapper cityMapper;

    @Resource
    StreetMapper streetMapper;

    @Resource
    DictiMapper dictiMapper;
    /**
     * 获得街道信息
     * @return
     */
    @Override
    public Street getStreetToday( String city, String street) {

        Integer cityId = dictiMapper.getCityIdByName(city);
        LOGGER.info("cityId: {}",cityId);
        Street streetToday = streetMapper.getStreetByCityIdAndName(cityId,street);

        return streetToday;
    }

    /**
     * index不需要参数 返回所有 街道信息
     * @return
     */
    @Override
    public List<StreetDTO> getStreetToday() {

        List<StreetDTO> list = streetMapper.getIndexData();
        LOGGER.info("index-list: {}",JSON.toJSONString(list));
        return list;
    }

    @Override
    public City getPieChartCity(String city) {
        City cityToday = cityMapper.getPieChartCity(city);
        return cityToday;
    }

    @Override
    public List<City> getCurrentCity7Days(String city) {
        List<City> list = cityMapper.getCurrentCity7Days(city);

        return list;
    }

    @Override
    public Map<String, BigDecimal> getCurrent30DaysCountry() {
            List<City30DTO> list = cityMapper.getCurrent30DaysCountry();
        LOGGER.info("30：：{}", JSON.toJSONString(list));
        Map<String, BigDecimal> map = new HashMap<>();
       /* for (int i=0;i<list.size();i++){
            map.put(i+"",list.get(i).getGarbageSum());
        }*/

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");


        for (City30DTO country : list) {
            map.put(country.getDivideTime(),country.getGarbageSum());
        }


        return map;
    }

    @Override
    public List<RankDTO> getCityRank() {
        List<City> list = cityMapper.getCityRank(TimeUtil.getTodayZeroDate());
        List<RankDTO> listRankDTO = new ArrayList<>();
        for (int i=0;i<list.size();i++) {
            RankDTO rankDTO = new RankDTO();
            rankDTO.setNum(i+1);
            rankDTO.setName(list.get(i).getCityName());
            rankDTO.setCarbageSum(list.get(i).getGarbageSum());
            rankDTO.setCompletionRate(list.get(i).getRecycleSum().divide(list.get(i).getGarbageSum(),4, BigDecimal.ROUND_HALF_UP));
            listRankDTO.add(rankDTO);
        }
        return listRankDTO;
    }

    @Override
    public List<RankDTO> getStreetRank() {
        List<Street> list = streetMapper.getStreetRank(TimeUtil.getTodayZeroDate());
        List<RankDTO> listRankDTO = new ArrayList<>();
        for (int i=0;i<list.size();i++) {
            RankDTO rankDTO = new RankDTO();
            rankDTO.setNum(i+1);
            rankDTO.setName(list.get(i).getStreetName());
            rankDTO.setCarbageSum(list.get(i).getGarbageSum());
            rankDTO.setCompletionRate(list.get(i).getRecycleSum().divide(list.get(i).getGarbageSum(),4, BigDecimal.ROUND_HALF_UP));
            listRankDTO.add(rankDTO);
        }
        return listRankDTO;
    }

    @Override
    public Street getPieChartStreet(String city, String street) {
        int cityId = dictiMapper.getCityIdByName(city);
        Street streetToday = streetMapper.getStreetByCityIdAndName(cityId,street);
        return streetToday;
    }


}
