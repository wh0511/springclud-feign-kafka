package com.feinno.example.service;/*
 * <p>Copyright: Copyright(C) 2017-2018</p >
 * <p> 公司：北京新媒传信科技有限公司</p >
 * FileName: ${file_name}
 * Description: xxxxx
 * History:
 * 版本号    作者       日期      操作
 * 1.2.0    liupenggc 2018-05-11    x
 * ...
 */

import com.feinno.example.service.impl.RedisServiceImpl;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "redis-client",fallback = RedisServiceImpl.class)
public interface RedisService {

    @RequestMapping(value = "/redis/test", method = RequestMethod.GET)
    String test();
}
