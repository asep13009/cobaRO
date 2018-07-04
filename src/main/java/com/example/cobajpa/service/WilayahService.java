package com.example.cobajpa.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cobajpa.DAO.WilayahDAO;
import com.example.cobajpa.model.Wilayah;
import com.example.cobajpa.repository.WilayahRepository;

@Service
public class WilayahService implements WilayahDAO{
	@Autowired
	WilayahRepository wilayahRepository;
	
	@Override
	public List<Wilayah> getAllWilayah() {
		List<Wilayah>  wilayahs = new ArrayList<>();
		wilayahRepository.findAll().forEach(wilayahs::add);
		return wilayahs;
	}

	@Override
	public Wilayah getByIdWilayah(long id) {
		Wilayah wilayah= wilayahRepository.findById(id).get();
		return wilayah;
	}

	@Override
	public void SaveOrUpdateWilayah(Wilayah wilayah) {
		wilayahRepository.save(wilayah);
		
	}

	@Override
	public void deleteIDWilayah(long id) {
		wilayahRepository.deleteById(id);
		
	}

	@Override
	public void deleteWlayah(Wilayah wilayah) {
		wilayahRepository.delete(wilayah);
		
	}

	@Override
	public List<Wilayah> getByLevel(Integer level) {
		List<Wilayah>  wilayahs = new ArrayList<>();
		wilayahRepository.findByLevel(level).forEach(wilayahs::add);
		return wilayahs;
	}
	
	public List<Wilayah> getByLevelParent(int level, long id){
		List<Wilayah>  wilayahs = new ArrayList<>();
		wilayahRepository.getByLevelParent(level, id).forEach(wilayahs::add);
		return wilayahs;
	}

}
