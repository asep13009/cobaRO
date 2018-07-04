package com.example.cobajpa.controller.admin;


import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.cobajpa.componen.EmailServiceImpl;
import com.example.cobajpa.controller.helper.EnkripHelper;
import com.example.cobajpa.model.Alamat;
import com.example.cobajpa.model.Karyawan;
import com.example.cobajpa.model.Login;
import com.example.cobajpa.service.AlamatService;
import com.example.cobajpa.service.DepartemenService;
import com.example.cobajpa.service.JabatanService;
import com.example.cobajpa.service.KaryawanService;
import com.example.cobajpa.service.RoleService;
import com.example.cobajpa.service.WilayahService;
		

@Controller
@SessionAttributes("penggunaaktif")
public class KaryawanController {
	@Autowired
	private KaryawanService karyawanService;
	@Autowired
	WilayahService ws;
	@Autowired
	AlamatService as;
	@Autowired
	private DepartemenService departemenService;
	
	@Autowired
	private JabatanService jabatanService;
	
	@Autowired
	private RoleService roleService;
	@Autowired
	EmailServiceImpl emailServiceImpl;
	
	@ModelAttribute("module")
	String module() {
		return "karyawan";
	}
	
	
//	@RequestMapping(value="karyawan.html",method=RequestMethod.GET)
//	public ModelAndView goKaryawan(@ModelAttribute("karyawan") Karyawan karyawan) {
//		return new ModelAndView("admin/karyawan","listkaryawan",karyawanService.getAllKaryawan());
//	}
	
	
	@RequestMapping(value = "/karyawan.html",method=RequestMethod.GET)
	public ModelAndView MasterKaryawan(@ModelAttribute("karyawan") Karyawan karyawan,@ModelAttribute("penggunaaktif") Login penggunaaktif){
		if (penggunaaktif.getRole().getId()!=3) {
			return new ModelAndView("redirect:error.html");
		}
		return new ModelAndView("admin/karyawan","listkaryawan",karyawanService.ListKaryawanByActive());
	}
	
	@RequestMapping(value="insertkaryawan.html",method=RequestMethod.GET)
	public ModelAndView  goformInsert(@ModelAttribute("karyawan") Karyawan karyawan,@ModelAttribute("penggunaaktif") Login penggunaaktif) {
		if (penggunaaktif.getRole().getId()!=3) {
			return new ModelAndView("redirect:error.html");
		}
		ModelAndView modelAndView= new ModelAndView();
		
		modelAndView.addObject("listprovinsi", ws.getByLevel(1));
		modelAndView.addObject("listkabupaten", ws.getByLevel(2));
		modelAndView.addObject("listkecamatan", ws.getByLevel(3));
		
		modelAndView.addObject("listkaryawan", karyawanService.getAllKaryawan());
		modelAndView.addObject("departemenlist", departemenService.getAll());
		modelAndView.addObject("jabatanlist", jabatanService.getAllJabatan());
		modelAndView.addObject("rolelist", roleService.getAllRole());
		modelAndView.setViewName("admin/insertkaryawan");	
		return modelAndView;
	}
	
	private String saveDirectory = "C:/Users/ASEP/Documents/workspace-sts-3.9.4.RELEASE/cobaRO/target/classes/static/images/user/";
	@RequestMapping(value="insertkaryawan.html",method=RequestMethod.POST)
	private String goInsertKaryawan(
			@ModelAttribute("karyawan") Karyawan karyawan, 
			@ModelAttribute("login") Login login,
	        @RequestParam("poto") MultipartFile file,
	        @RequestParam("password") String password,
	        RedirectAttributes redirectAttributes,
	        @ModelAttribute("Alamat") Alamat alamat,
	        
    		@RequestParam("optkecamatan") long idKec) throws NoSuchAlgorithmException
			{
		
		try {
			
			byte[] bytes = file.getBytes();
			
			String namaFoto= file.getOriginalFilename().replace(file.getOriginalFilename(), FilenameUtils.getBaseName(file.getOriginalFilename()).concat(currentDate) + "." + FilenameUtils.getExtension(file.getOriginalFilename())).toLowerCase();		
			Path path = Paths.get(saveDirectory + namaFoto);
			Files.write(path, bytes);
			karyawan.setPhotoUser(namaFoto);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		emailServiceImpl.sendMessage(karyawan.getEmail(),
				"Rapor Online- Data Login",
				"Selamat anda telah terdaftar!  "
				+ "Username : "+login.getUsername()+ " <br/> "
						+ "Password : "+login.getPassword()+" "
								+ "Silakan lihat website www.raporonline.org untuk login");
		
		login.setPassword(EnkripHelper.hash256(password));
		karyawan.setStatus("Active");
		karyawanService.SaveOrUpdateWithEmail(karyawan,login);
		alamat.setKaryawan(karyawan);
		alamat.setWilayah(ws.getByIdWilayah(idKec));
		as.SaveOrUpdateAlamat(alamat);
		return "redirect:karyawan.html";
	}
	 	
	String saveDirectory1="images/user/";
	
	@RequestMapping(value ="updatekaryawan.html",method=RequestMethod.GET)
    public ModelAndView formUpdateKaryawan(@RequestParam("id") int id,MultipartFile file,@ModelAttribute("penggunaaktif")Login penggunaaktif){
		if (penggunaaktif.getRole().getId()!=3) {
			return new ModelAndView("redirect:error.html");
		}
		Karyawan karyawan = karyawanService.getByIdKaryawan(id);
		String pathkaryawan = karyawan.getPhotoUser();
		Path path = Paths.get(saveDirectory1 + pathkaryawan);
		
		ModelAndView modelAndView= new ModelAndView();
		modelAndView.addObject("listprovinsi", ws.getByLevel(1));
		modelAndView.addObject("listkabupaten", ws.getByLevel(2));
		modelAndView.addObject("listkecamatan", ws.getByLevel(3));
		
		modelAndView.addObject("karyawan",karyawan);
		modelAndView.addObject("departemenlist", departemenService.getAll());
		modelAndView.addObject("jabatanlist", jabatanService.getAllJabatan());
		modelAndView.addObject("sama", karyawan.getDepartemen().getId());
		modelAndView.addObject("samajab", karyawan.getJabatan().getId());
		modelAndView.addObject("samawil", karyawan.getAlamats().get(0).getWilayah().getWilayah().getWilayah().getId());
		modelAndView.addObject("samaKAB", karyawan.getAlamats().get(0).getWilayah().getWilayah().getId());
		modelAndView.addObject("foto", path);
		modelAndView.setViewName("admin/updatekaryawan");
        return modelAndView;
    }
	
	String currentDate = new SimpleDateFormat("yyyyMMddHHmm").format(new Date());
	
	@RequestMapping(value ="updatekaryawan.html",method=RequestMethod.POST)
    public String procesUpdateKaryawan(
    		@ModelAttribute("karyawan") Karyawan karyawan, 
    		@RequestParam("poto") MultipartFile file, 
    		RedirectAttributes redirectAttributes,
    		@ModelAttribute("Alamat") Alamat a,
    		@RequestParam("optkecamatan") long idKec ){
		
		try {			
			if (file.isEmpty() == false   ) {
				byte[] bytes = file.getBytes();
				String namaFoto= file.getOriginalFilename().replace(file.getOriginalFilename(), FilenameUtils.getBaseName(file.getOriginalFilename()).concat(currentDate) + "." + FilenameUtils.getExtension(file.getOriginalFilename())).toLowerCase();
				Path path = Paths.get(saveDirectory + namaFoto);
				Files.write(path, bytes);
				karyawan.setPhotoUser(namaFoto);	
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		karyawan.setStatus("Active");
		karyawanService.SaveOrUpdateKaryawan1(karyawan);
		a.setKaryawan(karyawan);
		a.setWilayah(ws.getByIdWilayah(idKec));
		as.SaveOrUpdateAlamat(a);
        return "redirect:karyawan.html"; 	 	
    }
	
	@RequestMapping(value ="viewkaryawan.html",method=RequestMethod.GET)
    public ModelAndView formViewKaryawan(@RequestParam("id") int id, @ModelAttribute("penggunaaktif") Login penggunaaktif){
		if (penggunaaktif.getRole().getId()!=3) {
			return new ModelAndView("redirect:error.html");
		}
		Karyawan karyawan= karyawanService.getByIdKaryawan(id);
		ModelAndView modelAndView= new ModelAndView();
		modelAndView.addObject("karyawan", karyawan);
		modelAndView.addObject("departemenlist", karyawan.getDepartemen());
		modelAndView.addObject("foto",karyawan.getPhotoUser());
		modelAndView.addObject("jabatanlist", karyawan.getJabatan());
		modelAndView.setViewName("admin/viewkaryawan");
        return modelAndView;
    }
	
//	@RequestMapping(value="deletekaryawan")
//	public String deleteKary(@RequestParam("id") int id){
//		karyawanService.deleteIDKaryawan(id);
//		return "redirect:karyawan.html";
//    }	
	
	@RequestMapping(value="deletekaryawan")
	public String deleteKary(@RequestParam("id") long id){
		Karyawan karyawan =  karyawanService.getByIdKaryawan(id);
		karyawan.setStatus("Disable");
		karyawanService.SaveOrUpdateKaryawan1(karyawan);
		return "redirect:karyawan.html";
	}
	
	
}