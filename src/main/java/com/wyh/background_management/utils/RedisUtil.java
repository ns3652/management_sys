package com.wyh.background_management.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Component
public class RedisUtil {
    @Autowired
    private RedisTemplate<String,String> redisTemplate;


    //写入数据,不设置过期时间
    public void setData(String key, String value){
        redisTemplate.opsForValue().set(key, value);
    }

    //写入数据,并设置过期时间,单位：秒
    public void setDataAndExpireTime(String key, String value, Integer time){
        redisTemplate.opsForValue().set(key, value, time, TimeUnit.SECONDS);
    }

    public void setExpireTime(String key, Integer time){
        redisTemplate.expire(key, time, TimeUnit.SECONDS);
    }

    //获取数据
    public Object getData(String key){
        return redisTemplate.opsForValue().get(key);
    }

    /*
     *
     * 写入集合数据
     *
     *  */
    public void setListData(String key, ArrayList<String> datas){

        redisTemplate.opsForList().leftPushAll(key,datas);
    }

    /*
     *
     * 集合长度
     *
     *  */
    public long getListDataLength(String key){
        return redisTemplate.opsForList().size(key);
    }

    /*
     *
     * 删除并弹出左元素
     *
     * */
    public String leftPopData(String key){
        return  redisTemplate.opsForList().leftPop(key);
    }

    public List<String> getAllListData(String key){
        return redisTemplate.opsForList().range(key, 0, -1);
    }
}


