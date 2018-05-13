/*
 * <p>Copyright: Copyright(C) 2017-2018</p >
 * <p> 公司：北京新媒传信科技有限公司</p >
 * FileName: ${file_name}
 * Description: xxxxx
 * History:
 * 版本号    作者       日期      操作
 * 1.2.0    liupenggc 2018-05-11    x
 * ...
 */

package com.feinno.controller;

import com.feinno.entity.User;
import com.feinno.service.RedisService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liupenggc
 * @version 1.1.0
 * @date 2018-05-11 11:47
 */
@RestController
@RequestMapping(value = "/redis")
public class RedisController {

    private static final Logger logger = LoggerFactory.getLogger(RedisController.class);

    @Autowired
    private RedisService redisService;

    @RequestMapping(value = "/test")
    public String test() {
        String id = String.valueOf(System.currentTimeMillis());
        User user = new User(id,"liupenggc");
        redisService.add(user);
        logger.info("redis-info:"+ redisService.selectUserById("id").toString());
        return redisService.selectUserById("id").toString();
    }
}