package com.example.cobajpa.controller.user;


import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.cobajpa.model.Departemen;
import com.example.cobajpa.model.Jabatan;
import com.example.cobajpa.model.Karyawan;
import com.example.cobajpa.model.Login;
import com.example.cobajpa.service.DepartemenService;
import com.example.cobajpa.service.JabatanService;
import com.example.cobajpa.service.KaryawanService;


@Controller
@SessionAttributes("penggunaaktif")
public class BiodataController {
	@Autowired
	KaryawanService karyawanService;
	@Autowired
	DepartemenService departemenService;
	@Autowired
	JabatanService jabatanService;
	
	@ModelAttribute("module")
	String module() {
		return "biodata";
	}
	
	@RequestMapping(value="biodata.html")
	public String goBiodata() {
		return "user/biodata";
	}
	@RequestMapping(value="biodata.html",method=RequestMethod.POST)
//	@ResponseBody
	public String processUpdateBiodata( 

			@RequestParam("idKaryawan") Long idKaryawan, 
			@RequestParam("namaLengkap") String namaLengkap, 
			@RequestParam("agama") String agama,
			@RequestParam("jenisKelamin") String jenisKelamin,
			@RequestParam("kewarganegaraan") String kewarganegaraan,
			@RequestParam("noKTP") Integer noKTP,
			@RequestParam("statusPerkawinan") String statusPerkawinan,
			@RequestParam("tanggalLahir") Date tanggalLahir,
			@RequestParam("tempatLahir") String tempatLahir,
			@RequestParam("email") String email,
			@RequestParam("hp") String hp,
			@RequestParam("gantiDepartemen") Long departemen,
			@RequestParam("gantiJabatan") Long jabatan,
			@RequestParam("pendidikan") String pendidikan,
			@RequestParam("photoUser") String photoUser,
			
			@SessionAttribute("penggunaaktif") Login penggunaaktif,
			
			Model model,
			RedirectAttributes redirectAttributes) 
	{
			Karyawan karyawan= new Karyawan();
			karyawan.setIdKaryawan(idKaryawan);
			karyawan.setAgama(agama);
			karyawan.setEmail(email);
			karyawan.setHp(hp);
			karyawan.setJenisKelamin(jenisKelamin);
			karyawan.setKewarganegaraan(kewarganegaraan);
			karyawan.setNamaLengkap(namaLengkap);
			karyawan.setNoKTP(noKTP);
			karyawan.setStatusPerkawinan(statusPerkawinan);
			karyawan.setTempatLahir(tempatLahir);
			karyawan.setTanggalLahir(tanggalLahir);
			karyawan.setPhotoUser(photoUser);
			karyawan.setPendidikan(pendidikan);
			karyawan.setStatus("Active");

			Departemen departemen2 = departemenService.getById(departemen);
			
			Jabatan jabatan2 = jabatanService.getById(jabatan);
			
			karyawan.setDepartemen(departemen2);
			karyawan.setJabatan(jabatan2);
			
			
			
			karyawanService.SaveOrUpdateKaryawan(karyawan,penggunaaktif);
	
		
		return "redirect:biodata.html";
//			return departemen2.getNamaDepartemen()+departemen2.getId();
//			return jabatan2.getNamaJabatan()+jabatan2.getId();
			
	}
	
	
	/*@RequestMapping(value="biodata.html",method=RequestMethod.POST)
//	@ResponseBody
	public String processUpdateBiodata(@ModelAttribute("Karyawan") Karyawan karyawan,
	         RedirectAttributes redirectAttributes,
	         @ModelAttribute("penggunaaktif")Login login) {
		
		karyawan.setIdKaryawan(login.getKaryawan().getIdKaryawan());
		karyawanService.SaveOrUpdateKaryawan1(karyawan);
//		redirectAttributes.addAttribute("penggunaaktif", login);
			return "redirect:biodata.html";
///			return karyawan.getNamaLengkap();
	}*/
}
