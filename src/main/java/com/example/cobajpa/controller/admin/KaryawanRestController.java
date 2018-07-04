package com.example.cobajpa.controller.admin;

import java.security.NoSuchAlgorithmException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.cobajpa.controller.helper.EnkripHelper;
import com.example.cobajpa.model.Karyawan;
import com.example.cobajpa.model.Login;
import com.example.cobajpa.service.KaryawanService;
import com.example.cobajpa.service.LoginService;

@RestController
public class KaryawanRestController {
	@Autowired
	KaryawanService karyawanService;
	@Autowired
	LoginService loginService;
	
	@RequestMapping(value="/restkaryawannih")
	public List<Karyawan> listKaryawan(){
		return karyawanService.getAllKaryawan();
	}
	
	@RequestMapping(value="/restkaryawandepartemen")
	public List<Karyawan> listDepartemen1(){
		return karyawanService.getAllKaryawanBuatRes();
	}
	
	@RequestMapping(value="/restloginnih")
	public List<Login> listLogin(){
		return loginService.getAllLogin();
	}
	
	
	@RequestMapping(value="/API/isUserExist")
	public boolean isUserExist(@RequestParam("username") String username) {
		return loginService.getExisUsername(username);
		
	}
	@RequestMapping(value="/API/isPassExist")
	public boolean isPassExist(@RequestParam("password") String password) throws NoSuchAlgorithmException {
		return loginService.getExisPassword(EnkripHelper.hash256(password));
		
	}
}
