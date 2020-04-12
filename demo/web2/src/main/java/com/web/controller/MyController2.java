package com.web.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.web.feign.MyFeign2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("web")
public class MyController2 {
    @Autowired
    private MyFeign2 myFeign;

    @GetMapping("getdata")
    @HystrixCommand(fallbackMethod = "processHystrix_getdata")
    public String getdata() {
        return myFeign.get();
    }

    public String  processHystrix_getdata() {
       return "processHystrix_Get";
    }

}
