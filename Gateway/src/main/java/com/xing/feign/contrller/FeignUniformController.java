package com.xing.feign.contrller;

import com.alibaba.fastjson.JSONObject;
import com.xing.feign.ServiceOneFeign;
import com.xing.feign.ServiceThreeFeign;
import com.xing.feign.ServiceTwoFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/feignUniform")
public class FeignUniformController {
    //自动引入上一步编写的Feign接口
    @Autowired
    private ServiceOneFeign serviceOneFeign;
    @Autowired
    private ServiceTwoFeign serviceTwoFeign;
    @Autowired
    private ServiceThreeFeign serviceThreeFeign;

    //内部调用“SERVICE-ONE”微服务的“serviceOne”方法
    @RequestMapping("/serviceOne")
    public JSONObject serviceOne(){
        return serviceOneFeign.serviceOne();
    }

    //内部调用“SERVICE-TWO”微服务的“serviceOne”方法
    @RequestMapping("/serviceTwo")
    JSONObject serviceTwo(){
        return serviceTwoFeign.serviceTwo();
    }

    //内部调用“SERVICE-THREE”微服务的“serviceThree_toOne”方法
    @RequestMapping("/serviceThree_toOne")
    JSONObject serviceThree_toOne(){
        return serviceThreeFeign.serviceThree_toOne();
    }

    //内部调用“SERVICE-THREE”微服务的“serviceThree_toTwo”方法
    @RequestMapping("/serviceThree_toTwo")
    JSONObject serviceThree_toTwo(){
        return serviceThreeFeign.serviceThree_toTwo();
    }
}
