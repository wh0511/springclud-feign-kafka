package kafka;/*
 * <p>Copyright: Copyright(C) 2017-2018</p >
 * <p> 公司：北京新媒传信科技有限公司</p >
 * FileName: ${file_name}
 * Description: xxxxx
 * History:
 * 版本号    作者    日期    操作
 * 1.0    ${user} ${date}   x
 * ...
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author wanghang
 * @version 1.0
 * @date 2018/5/11 0011下午 12:47
 */
//@EnableDiscoveryClient
@SpringBootApplication
public class AppStart {
    public static void main(String[] args) throws InterruptedException {

//        ApplicationContext app = SpringApplication.run(AppStart.class, args);
        SpringApplication.run(AppStart.class, args);

    }
}
