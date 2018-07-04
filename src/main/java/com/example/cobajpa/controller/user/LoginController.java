package com.example.cobajpa.controller.user;


import java.security.NoSuchAlgorithmException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
//import org.springframework.web.servlet.ModelAndView;

import com.example.cobajpa.controller.helper.EnkripHelper;
//import com.example.cobajpa.model.Karyawan;
import com.example.cobajpa.model.Konten;
import com.example.cobajpa.model.Login;
import com.example.cobajpa.service.KaryawanService;
import com.example.cobajpa.service.KontenService;
import com.example.cobajpa.service.LoginService;


@Controller
@SessionAttributes("penggunaaktif")
public class LoginController {
	@Autowired
	LoginService loginService;
	@Autowired
	KaryawanService karyawanService;
	@Autowired
	KontenService kontenService;
	
	
//	@RequestMapping(value="login.html")
//	public ModelAndView getLogin(@ModelAttribute("Login") Login login,@ModelAttribute("karyawan") Karyawan karyawan,@RequestParam("password") String password,@RequestParam("username") String username) {
//		ModelAndView mav = new ModelAndView();
//		try {
//			
//			
//			Login penggunaaktif = loginService.getLogin(username, EnkripHelper.hash256(password));
//			
//			if(penggunaaktif==null) {
//				mav.setViewName("index");
//			}else if (penggunaaktif.getRole().getId()==1) { //atasan
//				mav.setViewName("atasan/home");
//			}else if (penggunaaktif.getRole().getId()==2){ //user penggunaaktif.getKaryawan().getJabatan().getId()==2
//				List<Konten> konten = kontenService.getAllKonten();
//				mav.addObject("listkonten", konten);
//				mav.setViewName("user/home");
//			}else if (penggunaaktif.getRole().getId()==3 ) { //admin
//				mav.addObject("listkaryawan",karyawanService.getAllKaryawan());
//				mav.setViewName("admin/karyawan");
//			}else {
//				mav.setViewName("index");
//			}
//
//			mav.addObject("penggunaaktif", penggunaaktif);
//
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//		return mav;		
//	}

	
	@RequestMapping(value=("/login.html"),method=RequestMethod.POST)
	public String getLogin(@ModelAttribute("Account") Login a,ModelMap mm,@RequestParam("password") String password,@RequestParam("username") String username) throws NoSuchAlgorithmException{
		String page = null;
		Login penggunaaktif = loginService.getLogin(username, EnkripHelper.hash256(password));
		
		if(penggunaaktif == null){
			mm.put("penggunaaktif",penggunaaktif);
			page="index.html";
		}
		else if(penggunaaktif.getRole().getId()==1) { //atasasn
			mm.put("listkaryawan",karyawanService.getAllKaryawan());
			mm.put("penggunaaktif",penggunaaktif);
			page="redirect:homeatasan.html";
		}
		else if(penggunaaktif.getRole().getId()==2){ //user
			List<Konten> konten = kontenService.getAllKonten();
			mm.put("listkonten", konten);
			mm.put("penggunaaktif",penggunaaktif);
			page="redirect:home.html";
		}
		else if(penggunaaktif.getRole().getId()==3){ //admin
			mm.put("listkaryawan",karyawanService.ListKaryawanByActive());
			mm.put("penggunaaktif",penggunaaktif);
			page="redirect:karyawan.html";
		}
		else {
			mm.put("penggunaaktif",penggunaaktif);
			page="index.html";
		}
		return page;
	}

}