package com.ori.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MasterController {
	
@RequestMapping("/hello")
public String hello() {
	
	return "Welcome to Master Origami";
}
}
