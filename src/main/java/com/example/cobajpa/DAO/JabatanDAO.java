package com.example.cobajpa.DAO;

import java.util.List;

import com.example.cobajpa.model.Jabatan;


public interface JabatanDAO {
	public List<Jabatan> getAllJabatan();
	public Jabatan getById(long id);
	public void SaveOrUpdate(Jabatan jabatan);
	public void deleteIDJabatan(long id);
	public void deleteJabatan(Jabatan jabatan);
}
