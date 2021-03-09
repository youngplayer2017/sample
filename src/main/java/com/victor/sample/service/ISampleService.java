package com.victor.sample.service;

import javax.servlet.http.HttpServletRequest;

/**
 * 用户表 服务类
 *
 * @author victor
 * @since 2020-07-22
 */
public interface ISampleService {

    String readRedis(String key) throws Exception;

    Boolean writeRedis(String key, String value);

    Boolean deleteRedis(String key);
}
