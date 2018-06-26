package com.i3.services.controller;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class ServicesController {
	
	@Value("${application}")
	private String message;
    @RequestMapping("/message")
	public String read() throws Exception {
    	
	return this.message;
		
	}
    
    @GetMapping("/message/{username}")
     public String message(@PathVariable("username") String username) {
        return String.format("Service: Message %s!\n", username);
    }
    
    
}
