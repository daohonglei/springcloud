package com.itmuch.cloud.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.itmuch.cloud.entity.User;

@RestController
public class MovieController {
	
  @Autowired
  private RestTemplate restTemplate;

  

  @SuppressWarnings("unchecked")
  @GetMapping("/movie/{id}")
  public Optional<User> findById(@PathVariable Long id) {
    return this.restTemplate.getForObject("http://microservice-provider-user/simple/"+id, Optional.class);
  }
}
