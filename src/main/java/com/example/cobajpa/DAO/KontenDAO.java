package com.example.cobajpa.DAO;

import java.util.List;

import com.example.cobajpa.model.Konten;

public interface KontenDAO {
	public List<Konten> getAllKonten();
	public Konten getById(long id);
	public void SaveOrUpdate(Konten konten);
	public void deleteIDKonten(long id);
	public void deleteKonten(Konten konten);
}
