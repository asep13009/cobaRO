package com.example.cobajpa.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("penggunaaktif")
public class KemajuanController {
	@ModelAttribute("module")
	String module() {
		return "kemajuan";
	}
	@RequestMapping(value="kemajuan.html")
	public String goKemajuan() {
		return "user/kemajuan";
	}
}
