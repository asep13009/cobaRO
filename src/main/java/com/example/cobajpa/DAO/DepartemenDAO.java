package com.example.cobajpa.DAO;

import java.util.List;

import com.example.cobajpa.model.Departemen;

public interface DepartemenDAO {
	public List<Departemen> getAll();
	public Departemen getById(long id);
	public void SaveOrUpdate(Departemen departemen);
	public void deleteID(long id);
	public void delete(Departemen  departemen);
}
