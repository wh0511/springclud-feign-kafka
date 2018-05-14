/*
 * <p>Copyright: Copyright(C) 2017-2018</p >
 * <p> 公司：北京新媒传信科技有限公司</p >
 * FileName: ${file_name}
 * Description: xxxxx
 * History:
 * 版本号    作者    日期    操作
 * 1.0    ${user} ${date}   x
 * ...
 */
package com.feinno.example.service;

import com.feinno.example.service.impl.KafkaServiceFailtureImpl;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * @author wanghang
 * @version 1.0
 * @date 2018/5/11 0011下午 16:10
 */
@FeignClient(value = "service-kafka", fallback = KafkaServiceFailtureImpl.class)
public interface kafkaService {


    @RequestMapping(value = "/kafka", method = RequestMethod.GET)
    public ResponseEntity<Map<String, Object>> kafka(@RequestParam("msg") String msg);
}
