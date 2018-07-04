package com.example.cobajpa.DAO;

import java.util.List;

import com.example.cobajpa.model.Alamat;



public interface AlamatDAO {
	public List<Alamat> getAllWilayah();
	public Alamat getByIdAlamat(long id);
	public void SaveOrUpdateAlamat(Alamat alamat);
	public void deleteIDAlamat(long id);
	public void deleteAlamat(Alamat alamat);
}
