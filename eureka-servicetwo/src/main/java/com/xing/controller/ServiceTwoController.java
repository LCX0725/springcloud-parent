package com.xing.controller;

import com.alibaba.fastjson.JSONObject;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServiceTwoController {
    //本接口发生异常时，通过熔断器，调用“serviceOneDown”方法
    @HystrixCommand(fallbackMethod = "serviceOneDown")
    @RequestMapping("/serviceTwo")
    @ResponseBody
    public JSONObject serviceTwo(){
        JSONObject ret = new JSONObject();

        ret.put("code",0);
        ret.put("message","Service two method return");

        String s = null;
        s.equals("abc");//人为产生一个空指针异常，引起熔断
        return ret;
    }
    public JSONObject serviceOneDown(){
        JSONObject ret = new JSONObject();

        ret.put("code",10500);//模拟发生熔断时的错误代码
        ret.put("message","serviceTwo业务模块的“serviceTwo”异常，发生熔断");

        return ret;
    }

}
