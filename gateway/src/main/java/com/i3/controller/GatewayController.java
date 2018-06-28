package com.i3.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GatewayController {
	  @RequestMapping(value = "/available")
	  public String available() {
	    return "Spring in Action";
	  }

	  @RequestMapping(value = "/checked-out")
	  public String checkedOut() {
	    return "Spring Boot in Action";
	  }
}
