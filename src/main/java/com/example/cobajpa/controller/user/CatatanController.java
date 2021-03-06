package com.example.cobajpa.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("penggunaaktif")
public class CatatanController {
	@ModelAttribute("module")
	String module() {
		return "catatan";
	}
	@RequestMapping(value="catatan.html")
	public String goCatatan() {
		return "user/catatan";
	}
}
