package com.xing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

//当前应用为Eureka客户端
@EnableEurekaClient
//开启Hystrix熔断功能
@EnableHystrix
//当前SpringBoot应用程序屏蔽数据库扫描（无需数据库）
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
//@EnableAutoConfiguration(exclude = DataSourceAutoConfiguration.class)

public class ServiceTwoApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServiceTwoApplication.class,args);
    }
}
