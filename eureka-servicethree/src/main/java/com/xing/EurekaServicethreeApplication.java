package com.xing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableEurekaClient
public class EurekaServicethreeApplication {

    //给RestTemplate的Bean方法前加上@LoadBalanced注解，表示此RestTemplate在发出请求时会使用Ribbon的负载均衡功能
    @LoadBalanced

    //服务3需要在内部通过RestTemplate调用服务1、服务2的接口
    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

    public static void main(String[] args) {
        SpringApplication.run(EurekaServicethreeApplication.class, args);

    }

}
