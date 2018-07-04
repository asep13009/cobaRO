package com.example.cobajpa.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.cobajpa.model.Jabatan;
import com.example.cobajpa.service.JabatanService;

@Controller
public class JabatanController {
	
	@Autowired
	public JabatanService service;
	
	@ModelAttribute("module")
	String module() {
		return "jabatan";
	}
	
	@RequestMapping(value="jabatan.html",method=RequestMethod.POST)
	public ModelAndView goJabatan(@ModelAttribute("jabatan")Jabatan jabatan) {
//		service.SaveOrUpdate(jabatan);
		return new ModelAndView("admin/jabatan", "lisjabatan", service.getAllJabatan()) ;
	}
	
	@RequestMapping(value="jabatan.html",method=RequestMethod.GET)
	public ModelAndView goJabatanAfterInsert(@ModelAttribute("jabatan")Jabatan jabatan) {
		return new ModelAndView("admin/jabatan","listjabatan",service.getAllJabatan());
	}
	
	@RequestMapping(value ="updatejabatan.html",method=RequestMethod.GET)
    public ModelAndView formUpdateJabatan(@RequestParam("id") int id){
        return new ModelAndView("admin/jabatan","listjabatan",service.getById(id));
    }
	@RequestMapping(value ="updatejabatan.html",method=RequestMethod.POST)
    public String insertUpdateJabatan(@ModelAttribute("jabatan")Jabatan jabatan){
		 service.SaveOrUpdate(jabatan);
	     return "redirect:jabatan.html";
    }
	
	@RequestMapping(value="deletejabatan.html")
	public String deleteJabatan(@RequestParam("id") int id){
        service.deleteIDJabatan(id);//delete nanti status. bukan delete
		return "redirect:jabatan.html";
    }
	
	@RequestMapping(value ="insertjabatan.html",method=RequestMethod.POST)
    public String insertJabatan(@ModelAttribute("jabatan")Jabatan jabatan){
        service.SaveOrUpdate(jabatan);
        return "redirect:jabatan.html";
    }
	

	
}
