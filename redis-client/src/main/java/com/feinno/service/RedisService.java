package com.feinno.service;/*
 * <p>Copyright: Copyright(C) 2017-2018</p >
 * <p> 公司：北京新媒传信科技有限公司</p >
 * FileName: ${file_name}
 * Description: xxxxx
 * History:
 * 版本号    作者       日期      操作
 * 1.2.0    liupenggc 2018-05-11    x
 * ...
 */

import com.feinno.entity.User;

public interface RedisService {

     void add(User user);

     User selectUserById(String id);

     void deleteUser(User user);
}
