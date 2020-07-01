package com.prj.Sprbt1.webservices.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
	@GetMapping("/")
	public Object hello() {
		return "Hello World!";
	}

}
