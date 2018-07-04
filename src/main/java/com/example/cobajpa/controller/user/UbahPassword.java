package com.example.cobajpa.controller.user;



import java.security.NoSuchAlgorithmException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.cobajpa.controller.helper.EnkripHelper;
import com.example.cobajpa.model.Login;
import com.example.cobajpa.service.LoginService;

@Controller
@SessionAttributes("penggunaaktif")
public class UbahPassword {
	@Autowired
	LoginService loginService;
	
	
	@ModelAttribute("module")
	String module() {
		return "gantipass";
	}
	
	@RequestMapping(value="gantipass.html")
	public String goGantiPass(@ModelAttribute("penggunaaktif") Login login, ModelMap modelMap) {
		modelMap.put("penggunaaktif", login);
		login.getUsername();
		return "user/gantipass";
	}
	
	@RequestMapping(value = "gantipass.html" , method = RequestMethod.POST)
	public String prosesgantipass(@ModelAttribute("penggunaaktif") Login login, @RequestParam("repassword") String password) throws NoSuchAlgorithmException {
		login.setPassword(EnkripHelper.hash256(password));
		loginService.SaveOrUpdateLogin(login);
		return "redirect:gantipass.html";
	}
}
