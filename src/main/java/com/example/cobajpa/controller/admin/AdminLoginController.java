package com.example.cobajpa.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.cobajpa.model.Login;
import com.example.cobajpa.service.DepartemenService;
import com.example.cobajpa.service.JabatanService;
import com.example.cobajpa.service.LoginService;

@Controller
public class AdminLoginController {
	@Autowired
	public LoginService adminLoginService;
	
	@Autowired
	public DepartemenService departemenService;
	
	@Autowired
	public JabatanService jabatanService;
	
	
	@ModelAttribute("module")
	String module() {
		return "pengguna";
	}
	
	@RequestMapping(value="pengguna.html",method=RequestMethod.GET)
	public ModelAndView adminPengguna(@ModelAttribute("pengguna") Login login,@ModelAttribute("penggunaaktif") Login penggunaaktif) {

		if (penggunaaktif.getRole().getId()!=3) {
			return new ModelAndView("redirect:error.html");
		}

		ModelAndView modelAndView2 = new ModelAndView();
		long id = 1;
		modelAndView2.addObject("pengguna", adminLoginService.getByIdLogin(id));
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("departemenlist", departemenService.getAll());
		modelAndView.addObject("listpengguna", adminLoginService.getAllLogin());
		modelAndView.addObject("jabatans", jabatanService.getAllJabatan());
		modelAndView.addObject("departemen", departemenService.getAll());
		modelAndView.setViewName("admin/pengguna");
		return modelAndView;
	}
	
	@RequestMapping(value="insertpengguna.html",method=RequestMethod.POST)
	public String goAfterInsertPengguna(@ModelAttribute("pengguna") Login login) {
		adminLoginService.SaveOrUpdateLogin(login);
		return "redirect:pengguna.html";
	}
	
}
