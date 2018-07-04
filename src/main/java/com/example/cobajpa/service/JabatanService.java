package com.example.cobajpa.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cobajpa.DAO.JabatanDAO;
import com.example.cobajpa.model.Jabatan;
import com.example.cobajpa.repository.JabatanRepository;

@Service
public class JabatanService implements JabatanDAO{
	@Autowired
	public JabatanRepository tambahJabatanRepository;
	
	@Override
	public List<Jabatan> getAllJabatan() {
		List<Jabatan> jabatans=new ArrayList<>();
		tambahJabatanRepository.findAll().forEach(jabatans::add);
		return jabatans;
	}

	@Override
	public Jabatan getById(long id) {
		Jabatan jabatan=tambahJabatanRepository.findById(id).get();
		return jabatan;
	}

	@Override
	public void SaveOrUpdate(Jabatan jabatan) {
		tambahJabatanRepository.save(jabatan);
		
	}

	@Override
	public void deleteIDJabatan(long id) {
		tambahJabatanRepository.deleteById(id);
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteJabatan(Jabatan jabatan) {
		// TODO Auto-generated method stub
		tambahJabatanRepository.delete(jabatan);
	}
	
}
