package com.wjm.wjmcrm.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class StringUtils {
    public static String getNowTime(){
        //设置日期格式
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date=new Date();
        return simpleDateFormat.format(date);
    }
}
