package com.itmuch.cloud.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.itmuch.cloud.entity.User;

@RestController
public class MovieController {
	
  @Autowired
  private RestTemplate restTemplate;

  @Autowired
  private LoadBalancerClient loadBalancerClient;

  @SuppressWarnings("unchecked")
  @GetMapping("/movie/{id}")
  public Optional<User> findById(@PathVariable Long id) {
    ServiceInstance serviceInstance = this.loadBalancerClient.choose("microservice-provider-user");
    System.out.println("===" + ":" + serviceInstance.getServiceId() + ":" + serviceInstance.getHost() + ":" + serviceInstance.getPort());

    return this.restTemplate.getForObject("http://microservice-provider-user/simple/" + id, Optional.class);
  }
}