package com.example.cobajpa.controller.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.example.cobajpa.model.Konten;
import com.example.cobajpa.model.Login;
import com.example.cobajpa.service.KontenService;




@Controller
@SessionAttributes("penggunaaktif")
public class HomeController {
	
	@Autowired
	KontenService kontenService;
	@ModelAttribute("module")
	String module() {
		return "home";
	}
	@RequestMapping(value="home.html")
	public ModelAndView goHome(@ModelAttribute("penggunaaktif") Login penggunaaktif) {
		if (penggunaaktif.getRole().getId()!=2) {
			return new ModelAndView("redirect:error.html");
		}
		
		ModelAndView mav = new ModelAndView();
		List<Konten> konten = kontenService.getAllKonten();
		mav.addObject("listkonten", konten);
		mav.setViewName("user/home");
		return mav;
		
		
	}
	
	
	
	
	
		
	
	
}
