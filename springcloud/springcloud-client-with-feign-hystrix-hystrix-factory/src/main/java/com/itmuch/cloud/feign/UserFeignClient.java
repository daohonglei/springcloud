package com.itmuch.cloud.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.itmuch.cloud.entity.User;

@FeignClient(name = "microservice-provider-user", /*fallback = HystrixClientFallback.class*/fallbackFactory = HystrixClientFactory.class)
public interface UserFeignClient {
  @RequestMapping(value = "/simple/{id}", method = RequestMethod.GET)
  User  findById(@PathVariable("id") Long id);
}
