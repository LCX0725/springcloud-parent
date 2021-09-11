package com.xing.servicetwodown; /**
 * 提供降级服务的业务类，实现了需要降级的Feign接口
 */

import com.alibaba.fastjson.JSONObject;
import com.xing.feign.ServiceTwoFeign;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class ServiceTwoDown implements FallbackFactory<ServiceTwoFeign> {
    @Override
    public ServiceTwoFeign create(Throwable throwable) {
        //返回实现了Feign业务接口的降级服务对象
        return new ServiceTwoFeign() {
            //以降级的方式重写了业务方法
            @Override
            public JSONObject serviceTwo() {
                JSONObject ret = new JSONObject();

                ret.put("code", 10501);//模拟发生服务降级时的错误代码
                ret.put("message", "ServiceTwo业务模块的“serviceTwo”接口降级!");

                return ret;
            }
        };
    }
}