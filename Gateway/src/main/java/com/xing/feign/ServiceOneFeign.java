package com.xing.feign;


import com.alibaba.fastjson.JSONObject;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("SERVICE-ONE")
public interface ServiceOneFeign {

    @RequestMapping("/serviceOne")
    JSONObject serviceOne();
}
