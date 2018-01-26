package io.pivotal.workshop.springbootweb.controller;

import io.pivotal.workshop.springbootweb.properties.PersonProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController1 {

	/**
	 * Reading the message from the properties file.
	 */
	@Value("${message}")
	private String message;
	final private PersonProperties personProperties;

	@RequestMapping("/hello/message")
	public String helloMessage() {
		return message;
	}

	@Autowired
	public HelloController1(PersonProperties personProperties) {
		this.personProperties = personProperties;
	}

	@RequestMapping("/hello")
	public String hello() {
		return "Hello, world from the spring boot war "
				+ "project in tomcat";
	}

	@RequestMapping("/")
	public String helloBoot() {
		return "Welcome to the spring boot world.";
	}

	@RequestMapping("/learn/properties")
	public String properties() {
		return personProperties.getGreeting() + " Spring Boot! " +
				personProperties.getFarewell() + " Spring Boot!";
	}
}