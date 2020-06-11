package com.wyh.background_management.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CommonUtil {
    private static int getRandom(int count) {
        return (int) Math.round(Math.random() * (count));
    }

    //产生length位随机数
    public static String getRandomNum(int length) {
        String string = "0123456789";

        StringBuffer sb = new StringBuffer();
        int len = string.length();
        for (int i = 0; i < length; i++) {
            sb.append(string.charAt(getRandom(len - 1)));
        }
        return sb.toString();
    }

    //获取当前系统时间
    public static String getCurrentTime(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return dateFormat.format(new Date());
    }

    //获取当前日期 年月日
    public static String getDay(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");      //yyyy-MM-dd HH:mm:ss

        Calendar calendar = Calendar.getInstance();
        Date date = calendar.getTime();
        String dateStringParse = sdf.format(date);
        return dateStringParse;
    }
}
