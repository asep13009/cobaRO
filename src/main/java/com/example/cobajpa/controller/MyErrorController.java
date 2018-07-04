package com.example.cobajpa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class MyErrorController   {
	
	@RequestMapping("/error.html")
	public String goError() {
		return "error";
	}
}
