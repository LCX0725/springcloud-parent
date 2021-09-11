package com.xing.feign;

import com.alibaba.fastjson.JSONObject;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("SERVICE-THREE")
public interface ServiceThreeFeign {

    @RequestMapping("/serviceThree_toOne")
    JSONObject serviceThree_toOne();

    @RequestMapping("/serviceThree_toOne")

    JSONObject serviceThree_toTwo();

}
