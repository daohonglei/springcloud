package com.web.feign;

import org.springframework.stereotype.Component;

@Component
public class MyHystrix2 implements MyFeign2 {
    @Override
    public String get() {
        return "MyHystrix222";
    }
}
