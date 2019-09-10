package com.itmuch.cloud.feign;


import com.itmuch.cloud.entity.User;
import com.itmuch.config.Configuration1;

import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;

import java.util.Optional;

@FeignClient(name = "microservice-provider-user", configuration = Configuration1.class)
public interface UserFeignClient {
  @RequestLine("GET /simple/{id}")
  Optional<User> findById(@Param("id") Long id);
}
