package com.example.cobajpa.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cobajpa.DAO.KontenDAO;
import com.example.cobajpa.model.Konten;
import com.example.cobajpa.repository.KontenRepository;

@Service
public class KontenService implements KontenDAO {
	@Autowired
	KontenRepository kontenRepository;
	
	@Override
	public List<Konten> getAllKonten() {
		List <Konten> kontens= new ArrayList<>();
		kontenRepository.findAll().forEach(kontens::add);
		return kontens;
	}

	@Override
	public Konten getById(long id) {
		Konten konten= kontenRepository.findById(id).get();
		return konten;
	}

	@Override
	public void SaveOrUpdate(Konten konten) {
		kontenRepository.save(konten);
		
	}

	@Override
	public void deleteIDKonten(long id) {
		kontenRepository.deleteById(id);
	}

	@Override
	public void deleteKonten(Konten konten) {
		kontenRepository.delete(konten);
		
	}

}
