package com.xing.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ServiceThreeController {
    //自动注入在主类中配置的RestTemplate对象，用它发送内部http请求
    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/serviceThree_toOne")
    @ResponseBody
    public JSONObject serviceThree_toOne() {
        //内部请求ServiceOne的接口，获取响应结果
        String strRet = restTemplate.getForObject("http://service-one/serviceOne", String.class);

        JSONObject ret = new JSONObject();

        //将响应结果拼接在本接口的data结果中，作为接口的响应结果返回
        ret.put("code", 0);
        ret.put("message", "Service three to one method return!");
        ret.put("data", strRet);

        return ret;
    }

    @RequestMapping("/serviceThree_toTwo")
    @ResponseBody
    public JSONObject serviceThree_toTwo() {
        //内部请求ServiceTwo的接口，获取响应结果
        String strRet = restTemplate.getForObject("http://service-two/serviceTwo", String.class);

        JSONObject ret = new JSONObject();

        //将响应结果拼接在本接口的data结果中，作为接口的响应结果返回
        ret.put("code", 0);
        ret.put("message", "Service three to two method return!");
        ret.put("data", strRet);

        return ret;
    }

    @RequestMapping("/serviceThree")
    @ResponseBody
    public JSONObject serviceThree(){
        JSONObject ret = new JSONObject();

        ret.put("code", 0);
        ret.put("message", "Service three method return!");

        return ret;
    }
}
