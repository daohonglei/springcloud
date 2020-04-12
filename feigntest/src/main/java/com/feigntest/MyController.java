package com.feigntest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("my")
public class MyController {

    @Autowired
    private MyFeign myFeign;

    @GetMapping("getuser")
    public String getuser() {
        return myFeign.get()+"23333333";
    }
}
