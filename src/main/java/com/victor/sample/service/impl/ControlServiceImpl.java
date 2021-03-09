package com.victor.sample.service.impl;

import com.victor.sample.service.IControlService;
import com.victor.sample.service.IRedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
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
public class ControlServiceImpl implements IControlService {

    @Autowired
    IRedisService redisService;

    final static String PREFIX = "LOCK_";
    final static int LOCK_TIME = 1; // second

    @Override
    public Boolean lock(String ipAddress) {
        if(!StringUtils.hasText(ipAddress)){
            return false;
        }
        return redisService.setIfAbsent(PREFIX+ipAddress,"",LOCK_TIME);
    }


}
