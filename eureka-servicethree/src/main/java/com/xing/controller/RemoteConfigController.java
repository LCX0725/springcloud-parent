package com.xing.controller;

import com.alibaba.fastjson.JSONObject;
import com.xing.config.RemoteConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class RemoteConfigController {
    @Autowired
    private RemoteConfig remoteConfig;

    //添加测试接口，获取配置信息类中获取到的远端配置信息
    @RequestMapping("/getRemoteConfig")
    public JSONObject getRemoteConfig() {
        JSONObject ret = new JSONObject();
        ret.put("username", remoteConfig.getUsername());
        ret.put("password", remoteConfig.getUserpass());
        return ret;

    }

}
