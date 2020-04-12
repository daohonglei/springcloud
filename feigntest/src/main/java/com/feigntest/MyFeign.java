package com.feigntest;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name="data",url="${feign.url}",fallback = MyHystrix.class)
public interface MyFeign {
    @RequestMapping(value = "/ticket/get",method = RequestMethod.GET)
    String get();
}
