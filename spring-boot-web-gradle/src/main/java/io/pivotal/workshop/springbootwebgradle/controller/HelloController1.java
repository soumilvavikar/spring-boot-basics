package io.pivotal.workshop.springbootwebgradle.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController1 {

	@RequestMapping("/hello")
	public String hello() {
		return "Hello, world from gradle appln.";
	}
}