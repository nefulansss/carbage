package com.nefu.carbage.mapper;

import com.nefu.carbage.entity.Dicti;
import java.util.List;

public interface DictiMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dicti
     *
     * @mbg.generated Thu Mar 26 12:31:26 GMT+08:00 2020
     */
    int deleteByPrimaryKey(Integer areaId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dicti
     *
     * @mbg.generated Thu Mar 26 12:31:26 GMT+08:00 2020
     */
    int insert(Dicti record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dicti
     *
     * @mbg.generated Thu Mar 26 12:31:26 GMT+08:00 2020
     */
    Dicti selectByPrimaryKey(Integer areaId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dicti
     *
     * @mbg.generated Thu Mar 26 12:31:26 GMT+08:00 2020
     */
    List<Dicti> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dicti
     *
     * @mbg.generated Thu Mar 26 12:31:26 GMT+08:00 2020
     */
    int updateByPrimaryKey(Dicti record);

    Integer getCityIdByName(String city);
}