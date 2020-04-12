package com.web.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name="server",fallback = MyHystrix2.class)
public interface MyFeign2 {
	@RequestMapping(value = "/user/get",method = RequestMethod.GET)
	String get();
}
