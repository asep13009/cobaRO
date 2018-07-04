package com.example.cobajpa.controller.admin;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.cobajpa.model.Wilayah;
import com.example.cobajpa.model.Wilayah2;
import com.example.cobajpa.service.WilayahService;

@Controller
public class WilayahController {
	
	@Autowired
	private WilayahService wilayahService;
	
	@ModelAttribute("module")
	String module() {
		return "wilayah";
	}
	
	@RequestMapping(value= "wilayah.html", method = RequestMethod.GET)
	public ModelAndView goWilayah() {
		ModelAndView  modelAndView = new ModelAndView();
		modelAndView.addObject("listwilayah", wilayahService.getAllWilayah());
		modelAndView.setViewName("admin/wilayah");
		return modelAndView;
	}
	
	
	@RequestMapping(value ="insertwilayah.html",method=RequestMethod.POST)
    public String insertWilayah(@ModelAttribute("wilayah")Wilayah wilayah){
		wilayahService.SaveOrUpdateWilayah(wilayah);
        return "redirect:wilayah.html";
    }
	
	
	@RequestMapping(value ="updatewilayah.html",method=RequestMethod.GET)
    public ModelAndView formUpdateWilayah(@RequestParam("id") int id){
        return new ModelAndView("admin/wilayah","listwilayah",wilayahService.getByIdWilayah(id));
    }
	@RequestMapping(value ="updatewilayah.html",method=RequestMethod.POST)
    public String insertUpdateWilayah(@ModelAttribute("wilayah")Wilayah wilayah){
        wilayahService.SaveOrUpdateWilayah(wilayah);
        return "redirect:wilayah.html";
    }
	@RequestMapping(value="deletewilayah.html")
	public String deleteWilayah(@RequestParam("id") int id){
		wilayahService.deleteIDWilayah(id);//delete nanti status. bukan delete
		return "redirect:wilayah.html";
    }
	
	

	@RequestMapping(value="viewwilayah.html",method=RequestMethod.GET)
	public ModelAndView goviewWilayah(@RequestParam("id") int id) {
		ModelAndView modelAndView = new ModelAndView();
		Wilayah wilayah =  wilayahService.getByIdWilayah(id);
		modelAndView.addObject("wilayah", wilayah);
		modelAndView.setViewName("admin/viewwilayah");
		
		return modelAndView;
	}
	
	
	@RequestMapping(value = "/wilayah2.html", method = RequestMethod.GET)
	public ModelAndView getPages() {

		ModelAndView model = new ModelAndView("admin/wilayah2");
		return model;

	}

	@RequestMapping(value = "/getTags", method = RequestMethod.GET)
	public @ResponseBody
	List<Wilayah2> getTags(@RequestParam String tagName) {

		return simulateSearchResult(tagName);

	}

	private List<Wilayah2> simulateSearchResult(String tagName) {

		List<Wilayah2> result = new ArrayList<Wilayah2>();

		// iterate a list and filter by tagName
		for (Wilayah2 tag : result) {
			if (tag.getNama().contains(tagName)) {
				result.add(tag);
			}
		}

		return result;
	}
}
