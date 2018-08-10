package com.i3.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.i3.service.MakeService;
import com.i3.service.redis.repository.RedisRepository;
import com.i3.service.redis.vo.Payment;

@Controller
public class WebController {
	@Autowired
	MakeService makeService;
	 @Autowired
	    private RedisRepository redisRepository;
	 
	@GetMapping("/message/{username}")
	public String getMessageInfo(Model model,@PathVariable("username") String username) {
		model.addAttribute("message",makeService.message(username) );
		return "message-view";
	}
	
	
	@RequestMapping("/")
	public String index() {
		return "index";
	}
	@RequestMapping("/keys")
	public @ResponseBody Map<Object,Object> keys() {
		return redisRepository.findAllPayments();
	}
	 @RequestMapping(value = "/add", method = RequestMethod.POST)
	    public ResponseEntity<String> add(@RequestParam String key, @RequestParam String value){
		Payment payment =new Payment();
		payment.setId(key);
		payment.setName(value);
		redisRepository.add(payment);
		return new ResponseEntity<>(org.springframework.http.HttpStatus.OK);
	}
}
