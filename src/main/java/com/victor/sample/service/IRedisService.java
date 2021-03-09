package com.victor.sample.service;

/**
 * 用户表 服务类
 *
 * @author victor
 * @since 2020-07-22
 */
public interface IRedisService {

    String readRedis(String key);

    void writeRedis(String key, String value, int time);

    Boolean setIfAbsent(String key, String value, int time);

    Boolean deleteRedis(String key);
}
