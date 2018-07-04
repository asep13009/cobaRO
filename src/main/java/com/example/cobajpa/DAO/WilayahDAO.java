package com.example.cobajpa.DAO;

import java.util.List;

import com.example.cobajpa.model.Wilayah;


public interface WilayahDAO {
	public List<Wilayah> getAllWilayah();
	public Wilayah getByIdWilayah(long id);
	public void SaveOrUpdateWilayah(Wilayah wilayah);
	public void deleteIDWilayah(long id);
	public void deleteWlayah(Wilayah wilayah);
	public List<Wilayah> getByLevel(Integer level);
}
