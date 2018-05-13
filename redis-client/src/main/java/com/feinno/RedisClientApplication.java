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

package com.feinno;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author liupenggc
 * @version 1.1.0
 * @date 2018-05-11 15:40
 */
@EnableDiscoveryClient
@SpringBootApplication
public class RedisClientApplication {
    public static void main(String[] args) {
        SpringApplication.run(RedisClientApplication.class, args);
    }
}