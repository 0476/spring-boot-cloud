package com.ailikes.svca.controller;

import com.ailikes.svca.client.ServiceBClient;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EurekaDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RefreshScope
@RestController
@Api("Swagger接口")
public class SwaggerTestController {

    @Value("${name:unknown}")
    private String name;

    @Autowired
    EurekaDiscoveryClient discoveryClient;
    @Autowired
    private ServiceBClient serviceBClient;

    @ApiOperation("Swagger接口方法")
    @GetMapping(value = "/swagger")
    public String printServiceA() {
        ServiceInstance serviceInstance = discoveryClient.getLocalServiceInstance();
        return serviceInstance.getServiceId() + " (" + serviceInstance.getHost() + ":" + serviceInstance.getPort() + ")" + "===>name:" + name + "<br/>" + serviceBClient.printServiceB();
    }

}