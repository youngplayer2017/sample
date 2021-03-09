package com.victor.sample.service.impl;

import com.victor.sample.service.IRedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * 用户表 服务实现类
 *
 * @author victor
 * @since 2020-07-22
 */
@Service
public class RedisServiceImpl implements IRedisService {

    @Autowired
    StringRedisTemplate redisTemplate;

    @Override
    public String readRedis(String key) {
        return redisTemplate.opsForValue().get(key);
    }

    @Override
    public void writeRedis(String key, String value, int time){
        redisTemplate.opsForValue().set(key, value, time, TimeUnit.SECONDS);
    }

    @Override
    public Boolean setIfAbsent(String key, String value, int time){
        return redisTemplate.opsForValue().setIfAbsent(key, value, time, TimeUnit.SECONDS);
    }

    @Override
    public Boolean deleteRedis(String key) {
        return redisTemplate.delete(key);
    }
}
