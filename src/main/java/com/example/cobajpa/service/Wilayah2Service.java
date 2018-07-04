package com.example.cobajpa.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cobajpa.model.Wilayah2;
import com.example.cobajpa.repository.Wilayah2Repository;

@Service
public class Wilayah2Service {
	@Autowired
	Wilayah2Repository wilayah2Repository;
	
	public List<Wilayah2> getAllWilayah() {
		List<Wilayah2>  wilayah2s = new ArrayList<>();
		wilayah2Repository.findAll().forEach(wilayah2s::add);
		return wilayah2s;
	}
}
