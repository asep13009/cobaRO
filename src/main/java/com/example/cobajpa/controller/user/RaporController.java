package com.example.cobajpa.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;


@Controller
@SessionAttributes("penggunaaktif")
public class RaporController {
	@ModelAttribute("module")
	String module() {
		return "rapor";
	}
	@RequestMapping(value="rapor.html")
	public String goRapor() {
		return "user/rapor";
	}
}
