package com.nefu.carbage.controller;

import com.nefu.carbage.CarbageApplication;
import com.nefu.carbage.scheduled.MyScheduled;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @program: carbage
 * @description:
 * @author: nefulan
 * @create: 2020-03-26 15:59
 **/
//@SpringBootTest(classes = CarbageApplication.class)
//@RunWith(SpringRunner.class)
public class ScheduledTest {

    @Autowired
    MyScheduled myScheduled;

    /*@Test
    public void testInsertSQL(){
        myScheduled.insertSql();
    }
*/
}
