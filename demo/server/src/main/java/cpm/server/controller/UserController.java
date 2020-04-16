package cpm.server.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserController {
	public static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
	@GetMapping("get")
	public String get() {
		LOGGER.info("hello");
		return "hello";
	}
}
