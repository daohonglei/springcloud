package com.web.feign;

import org.springframework.stereotype.Component;

@Component
public class MyHystrix implements MyFeign {
    @Override
    public String get() {
        return "MyHystrix";
    }
}
