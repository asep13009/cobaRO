package com.example.cobajpa.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cobajpa.model.Jabatan;
import com.example.cobajpa.model.Wilayah;
import com.example.cobajpa.model.Wilayah2;
import com.example.cobajpa.service.JabatanService;
import com.example.cobajpa.service.Wilayah2Service;
import com.example.cobajpa.service.WilayahService;

@RestController
public class WilayahRestController {
	@Autowired
	Wilayah2Service wilayah2service;
	@Autowired
	WilayahService ws;
	@Autowired
	JabatanService jabatanservice; 
	
	@RequestMapping(value="/wilayahrestnih")
	public List<Wilayah2> listwilayah(String nama){
		return wilayah2service.getAllWilayah();
		
	}
	
	@RequestMapping(value="/jabatanrestnih")
	public List<Jabatan> listJabatan(String nama){
		return jabatanservice.getAllJabatan();
		
	}
	
	@RequestMapping("/wilayahby")
	public List<Wilayah> getWilayah(int level,long id) {
		return ws.getByLevelParent(level, id);
	}

	
}
