package com.example.cobajpa.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cobajpa.DAO.DepartemenDAO;
import com.example.cobajpa.model.Departemen;
import com.example.cobajpa.repository.DepartemenRepository;

@Service
public class DepartemenService  implements DepartemenDAO{
	@Autowired
	DepartemenRepository departemenRepository;

	@Override
	public List<Departemen> getAll() {
		List <Departemen> departemens= new ArrayList<>();
		departemenRepository.findAll().forEach(departemens::add);
		return departemens;
	}

	@Override
	public Departemen getById(long id) {
		Departemen departemen= departemenRepository.findById(id).get();
		return departemen;
	}

	@Override
	public void SaveOrUpdate(Departemen departemen) {
		departemenRepository.save(departemen);
		
	}

	@Override
	public void deleteID(long id) {
		departemenRepository.deleteById(id);
		
	}

	@Override
	public void delete(Departemen departemen) {
		departemenRepository.delete(departemen);
		
	}

	public List<Departemen>ListDepartemenByActive(){
		return  departemenRepository.ListDepartemenByActive();
	}
	
}
