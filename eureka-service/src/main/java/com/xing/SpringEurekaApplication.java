package com.xing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;


//当前Spring应用程序屏蔽数据库扫描（无需数据库)
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
//当前应用程序作为Eureka服务器
@EnableEurekaServer
public class SpringEurekaApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringEurekaApplication.class,args);
    }
}
