package com.nefu.carbage.util;

import javax.xml.crypto.Data;
import java.util.Calendar;
import java.util.Date;

/**
 * @program: spring-weather
 * @description:
 * @author: nefulan
 * @create: 2020-03-21 20:27
 **/

public class TimeUtil {

    /**
     * 今日凌晨
     * @return
     */
    public static Date getTodayZeroDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        Date zero = calendar.getTime();
        return zero;
    }


}