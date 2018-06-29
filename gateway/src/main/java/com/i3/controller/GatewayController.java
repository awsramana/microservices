package com.i3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.i3.service.MakeService;

@RestController
public class GatewayController {
	@Autowired
	MakeService makeService;
	@GetMapping("/message/{username}")
	public String getMessageInfo(@PathVariable("username") String username) {
		return makeService.message(username);
	}
	
	  @RequestMapping(value = "/available")
	  public String available() {
	    return "Spring in Action";
	  }

	  @RequestMapping(value = "/checked-out")
	  public String checkedOut() {
	    return "Spring Boot in Action";
	  }
}
