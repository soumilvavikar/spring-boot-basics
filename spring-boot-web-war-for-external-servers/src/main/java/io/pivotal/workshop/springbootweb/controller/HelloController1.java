package io.pivotal.workshop.springbootweb.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController1 {

	@RequestMapping("/hello")
	public String hello() {
		return "Hello, world from the spring boot war "
				+ "project in tomcat";
	}

	@RequestMapping("/")
	public String helloBoot() {
		return "Welcome to the spring boot world.";
	}
}