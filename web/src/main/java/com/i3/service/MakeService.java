package com.i3.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class MakeService {
	
	@HystrixCommand(fallbackMethod="defaultMessage")
	public String message(String userName) {
		String SERVICE_URL="http://localhost:9081/message/{userName}";
		return new RestTemplate().getForObject(SERVICE_URL, String.class, userName);
	}
	public String defaultMessage(String userName) {
		return "Main Service Failed: Now execute default method , "+userName;
	}

}
