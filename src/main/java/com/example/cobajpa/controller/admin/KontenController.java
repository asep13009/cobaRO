package com.example.cobajpa.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.cobajpa.model.Konten;
import com.example.cobajpa.service.KontenService;

@Controller
public class KontenController {
	@Autowired
	public KontenService kontenService;
	
	@ModelAttribute("module")
	String module() {
		return "konten";
	}
	
	@RequestMapping(value="/konten.html", method=RequestMethod.GET)
	public ModelAndView goKonten(@ModelAttribute("konten") Konten konten) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("listkonten", kontenService.getAllKonten());
		modelAndView.setViewName("admin/konten");
		return modelAndView;
	}
	
	@RequestMapping(value="konten.html",method=RequestMethod.POST)
	public ModelAndView goAfterInsertKonten(@ModelAttribute("konten") Konten konten) {
		return new ModelAndView("admin/konten","listkonten",kontenService.getAllKonten());
	}
	
	
	@RequestMapping(value ="insertkonten.html",method=RequestMethod.POST)
    public String insertKonten(@ModelAttribute("konten")Konten konten){
		kontenService.SaveOrUpdate(konten);
        return "redirect:konten.html";
    }
	
	@RequestMapping(value ="updatekonten.html",method=RequestMethod.GET)
    public ModelAndView formUpdateKonten(@RequestParam("id") int id){
        return new ModelAndView("admin/konten","listkonten",kontenService.getById(id));
    }
	@RequestMapping(value ="updatekonten.html",method=RequestMethod.POST)
    public String insertUpdateDepartemen(@ModelAttribute("konten")Konten konten){
        kontenService.SaveOrUpdate(konten);;
        return "redirect:konten.html";
    }
	

	@RequestMapping(value="deletekonten.html")
	public String deleteKonten(@RequestParam("id") int id){
		kontenService.deleteIDKonten(id);//delete nanti status. bukan delete
		return "redirect:konten.html";
    }
	
}
