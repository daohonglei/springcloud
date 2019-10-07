package com.itmuch.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.netflix.zuul.filters.discovery.PatternServiceRouteMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableZuulProxy
public class ZuulApplication {
  @Bean
  @LoadBalanced
  public RestTemplate restTemplate() {
    RestTemplate restTemplate=new RestTemplate();
    return restTemplate;
  }

  public static void main(String[] args) {
    SpringApplication.run(ZuulApplication.class, args);
  }

  @Bean
  public PatternServiceRouteMapper serviceRouteMapper() {
    return new PatternServiceRouteMapper(
            "(?<name>^.+)-(?<version>v.+$)",
            "${version}/${name}");   //http://172.21.224.1:7940/v1/microservice-provider-user/simple/1
  }
}
