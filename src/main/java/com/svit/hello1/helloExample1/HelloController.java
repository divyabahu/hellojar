package com.svit.hello1.helloExample1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HelloController {
	@GetMapping("/printHello")
	public String printHello() {
		return "hello World";
		}
	
	@GetMapping("/user")
	public String user() {
		return "WELCOME TEAM";
	}
	
	@GetMapping("/admin")
	public String admin() {
	 return "I am admin1";
	}

}
