package com.victor.sample.service;

import javax.servlet.http.HttpServletRequest;

/**
 * 用户表 服务类
 *
 * @author victor
 * @since 2020-07-22
 */
public interface IControlService {

    Boolean lock(String ipAddress);
}
