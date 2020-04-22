package com.web.controller;

import com.App;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.web.feign.MyFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("web")
public class MyController {
    @Autowired
    private MyFeign myFeign;

    App app=new App();

    @GetMapping("get")
    @HystrixCommand(fallbackMethod = "processHystrix_Get")
    public String getData() {
        app.test();
        return myFeign.getUser();
    }

    public String  processHystrix_Get() {
        app.test();
       return "processHystrix_Get";
    }

}
