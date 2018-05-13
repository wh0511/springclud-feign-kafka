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

package com.feinno.service;

import com.feinno.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

/**
 * @author liupenggc
 * @version 1.1.0
 * @date 2018-05-11 10:57
 */
@Service
public class RedisServiceImpl implements RedisService {

    @Autowired
    private StringRedisTemplate redisTemplate;


    public void add(User user) {
        User user1 = selectUserById(user.getId());
        if (user1 != null){
            deleteUser(user);
        }
        redisTemplate.opsForValue().set("id", user.getId());
        redisTemplate.opsForValue().set("name", user.getName());
    }

    public User selectUserById(String id) {
        return new User(redisTemplate.opsForValue().get("id"),redisTemplate.opsForValue().get("name"));
    }

    public void deleteUser(User user){
        redisTemplate.delete("id");
        redisTemplate.delete("name");
    }
}
