package com.i3.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MakeService {
	
	
	public String message(String userName) {
		String SERVICE_URL="http://localhost:9081/message/{userName}";
		return new RestTemplate().getForObject(SERVICE_URL, String.class, userName);
	}
	

}
