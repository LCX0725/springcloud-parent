package com.xing.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServiceOneController {
    @RequestMapping("/serviceOne")
    @ResponseBody
    public JSONObject serviceOne(){
        JSONObject ret = new JSONObject();

        ret.put("code",0);
        ret.put("message","Service one method return");
        return ret;
    }
}
