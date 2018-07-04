package com.example.cobajpa.controller.user;


import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@SessionAttributes("penggunaaktif")
public class LogoutController {
	
	
	@RequestMapping(value = "/logout.html")

	public String logout(HttpSession session, SessionStatus status)  {
		status.setComplete();
		session.removeAttribute("penggunaaktif") ;
	  
		 return "index";
	}
}
