package com.i3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.i3.service.MakeService;

@Controller
public class WebController {
	@Autowired
	MakeService makeService;
	@GetMapping("/message/{username}")
	public String getMessageInfo(Model model,@PathVariable("username") String username) {
		model.addAttribute("message",makeService.message(username) );
		return "message-view";
	}
	
	
	@RequestMapping("/")
	public String index() {
		return "index";
	}
	
}
