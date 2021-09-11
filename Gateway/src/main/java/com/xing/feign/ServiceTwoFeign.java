package com.xing.feign;

import com.alibaba.fastjson.JSONObject;

import com.xing.servicetwodown.ServiceTwoDown;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

//关联降级服务，注解中value值为要调用的服务提供者（其他微服务）的服务ID名称
//fallbackFactory为我们编写的提供“降级服务对象”的工厂类
@FeignClient(value = "SERVICE-TWO",fallbackFactory = ServiceTwoDown.class)
public interface ServiceTwoFeign {
    //内部调用“SERVICE-TWO”微服务的“serviceOne”方法
    @RequestMapping("/serviceTwo")
    JSONObject serviceTwo();

}
