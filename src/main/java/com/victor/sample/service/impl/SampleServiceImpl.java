package com.victor.sample.service.impl;

import com.victor.sample.service.IControlService;
import com.victor.sample.service.IRedisService;
import com.victor.sample.service.ISampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * 用户表 服务实现类
 *
 * @author victor
 * @since 2020-07-22
 */
@Service
public class SampleServiceImpl implements ISampleService {

    @Autowired
    IControlService controlService;

    @Autowired
    IRedisService redisService;

    static final int STORE_TIME = 60;

    @Override
    public String readRedis(String key) throws Exception {

        String result = redisService.readRedis(key);
        return result;
    }

    @Override
    public Boolean writeRedis(String key, String value) {
        if(StringUtils.hasText(key)){
            throw new IllegalArgumentException("Key is not valid");
        }
        if(StringUtils.hasText(value)){
            throw new IllegalArgumentException("Value is not valid");
        }
        redisService.writeRedis(key,value,STORE_TIME);
        return  true;
    }

    @Override
    public Boolean deleteRedis(String key) {
        if(StringUtils.hasText(key)){
            throw new IllegalArgumentException("Key is not valid");
        }
        return redisService.deleteRedis(key);
    }


}
