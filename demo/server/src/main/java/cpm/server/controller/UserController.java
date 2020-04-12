package cpm.server.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserController {
	@GetMapping("get")
	public String get() {
		System.out.println("hello");
		return "hello";
	}
}
