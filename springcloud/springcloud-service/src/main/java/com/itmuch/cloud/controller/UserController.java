package com.itmuch.cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.itmuch.cloud.entity.User;
import com.itmuch.cloud.repository.UserRepository;

@RestController
public class UserController {

  @Autowired
  private UserRepository userRepository;

  @GetMapping("/simple/{id}")
  public User findById(@PathVariable Long id) {
	  User user = this.userRepository.findById(id).get();
    return user;
  }
  
  @PostMapping("/user")
  public User postUser(@RequestBody User user) {
    return user;
  }
  
  // 该请求不会成功
  @GetMapping("/get-user")
  public User getUser(User user) {
    return user;
  }
  
}
