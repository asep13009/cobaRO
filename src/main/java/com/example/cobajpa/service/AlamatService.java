package com.example.cobajpa.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cobajpa.DAO.AlamatDAO;
import com.example.cobajpa.model.Alamat;
import com.example.cobajpa.repository.AlamatRepository;

@Service
public class AlamatService implements AlamatDAO {
	@Autowired
	AlamatRepository alamatRepo;
	
	@Override
	public List<Alamat> getAllWilayah() {
		List <Alamat> alamats= new ArrayList<>();
		alamatRepo.findAll().forEach(alamats::add);
		return alamats;
	}

	@Override
	public Alamat getByIdAlamat(long id) {
		Alamat alamat= alamatRepo.findById(id).get();
		return alamat;
	}

	@Override
	public void SaveOrUpdateAlamat(Alamat alamat) {
		alamatRepo.save(alamat);
		
	}

	@Override
	public void deleteIDAlamat(long id) {
		alamatRepo.deleteById(id);
		
	}

	@Override
	public void deleteAlamat(Alamat alamat) {
		alamatRepo.delete(alamat);;
		
	}

}
