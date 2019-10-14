package com.ori.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MasterController {
	
@RequestMapping("/hello")
public String hello() {
	
	return "Welcome to Master Origami";
}
@RequestMapping("/name/{message}")
public String getName(@PathVariable("message") String m) {
	
	return "your Message is :"+ m;
}
@RequestMapping("/name/{name}")
public String displayName(@PathVariable("name") String m) {
	
	return "Welcome to :"+ m;
}
}
