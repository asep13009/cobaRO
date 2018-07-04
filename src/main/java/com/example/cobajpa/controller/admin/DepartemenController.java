package com.example.cobajpa.controller.admin;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.cobajpa.model.Departemen;
import com.example.cobajpa.service.DepartemenService;
import com.example.cobajpa.service.KaryawanService;

@Controller
public class DepartemenController {
	@Autowired
	public DepartemenService departemenService;
	@Autowired
	public KaryawanService karyawanService;
	
	@ModelAttribute("module")
	String module() {
		return "departemen";
	}
	
/*	@RequestMapping(value="departemen.html",method=RequestMethod.GET)
	public ModelAndView goDepartemen(@ModelAttribute("departemen") Departemen departemen) {
		ModelAndView modelAndView = new  ModelAndView();
		modelAndView.addObject("listpenilai", karyawanService.getAllKaryawan());
		modelAndView.addObject("listdepartemen",departemenService.getAll());
		modelAndView.setViewName("admin/departemen");
		return modelAndView;
	}*/
	
	
	@RequestMapping(value = "/departemen.html",method=RequestMethod.GET)
	public ModelAndView MasterDepartemen(@ModelAttribute("departemen") Departemen departemen){
		ModelAndView modelAndView = new  ModelAndView();
		modelAndView.addObject("listpenilai", karyawanService.getAllKaryawan());
		modelAndView.addObject("listdepartemen",departemenService.ListDepartemenByActive());
		modelAndView.setViewName("admin/departemen");
		return modelAndView;
				
	}
	
	
	@RequestMapping(value ="insertdepartemen.html",method=RequestMethod.POST)
    public String insertDepartemen(@ModelAttribute("departemen")Departemen departemen){
		departemen.setStatus("Active");
		departemenService.SaveOrUpdate(departemen);
        return "redirect:departemen.html";
    }
	
	@RequestMapping(value="departemen.html",method=RequestMethod.POST)
	public ModelAndView goAfterInsertDepartemen(@ModelAttribute("departemen") Departemen departemen) {
		return new ModelAndView("admin/departemen","listdepartemen",departemenService.getAll());
	}
	
//	@RequestMapping(value ="updatedepartemen.html",method=RequestMethod.GET)
//    public ModelAndView formUpdateDepartemen(@RequestParam("id") int id){
//		ModelAndView modelAndView = new ModelAndView();
//		Departemen departemen = departemenService.getById(id);
//		
//		modelAndView.addObject("samaNama", departemen.getPenilai().getIdKaryawan());
//		modelAndView.addObject("listdepartemen", departemen);
//		modelAndView.setViewName("admin/departemen");
//		return modelAndView;
//    }
	@RequestMapping(value ="updatedepartemen.html",method=RequestMethod.POST)
    public String insertUpdateDepartemen(@ModelAttribute("departemen")Departemen departemen){
		departemen.setStatus("Active");
		departemenService.SaveOrUpdate(departemen);
        return "redirect:departemen.html";
    }
//	@RequestMapping(value="deletedepartemen.html")
//	public String deleteDepartemen(@RequestParam("id") int id){
//		departemenService.deleteID(id);//delete nanti status. bukan delete
//		return "redirect:departemen.html";
//    }
	
	@RequestMapping(value="deletedepartemen.html")
	public String deleteDepartemen(@RequestParam("id") long id){
		Departemen departemen =  departemenService.getById(id);
		departemen.setStatus("Disable");
		departemenService.SaveOrUpdate(departemen);;
		return "redirect:departemen.html";
	}
	
	

	@RequestMapping(value="viewdepartemen.html",method=RequestMethod.GET)
	public ModelAndView goviewDepartemen(@RequestParam("id") int id) {
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("departemen",departemenService.getById(id));
		modelAndView.addObject("listkaryawan",karyawanService.getByDepartemen(id));
		modelAndView.setViewName("admin/viewdepartemen");
		
		return modelAndView;
	}
}
