package com.lpu.demo_security1.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Sec {
	
	@RequestMapping("/hi")
	public String Sec1() {
		return "Hii";
	}
}
