package com.i3.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MakeService {
	
	
	public String message(String userName) {
		String SERVICE_URL="http://192.168.64.8:30024/message/{userName}";
		System.out.println("Gateway URL::"+SERVICE_URL);
		return new RestTemplate().getForObject(SERVICE_URL, String.class, userName);
	}
	

}
