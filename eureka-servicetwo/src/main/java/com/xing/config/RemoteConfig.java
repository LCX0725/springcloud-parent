package com.xing.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * 此类用于从SpringCloud-Config配置中心微服务中获取配置信息
 */
//此类为Spring的配置组件
@Configuration
//配置文件中的前缀键名，必须与配置文件中某个键保持一致！
@ConfigurationProperties(prefix = "my-db-config")
public class RemoteConfig {
    //两个属性对应上面前缀键名之后的子配置键名称
    private String username;
    private String userpass;

    //必须提供getter、setter
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserpass() {
        return userpass;
    }

    public void setUserpass(String userpass) {
        this.userpass = userpass;
    }
}