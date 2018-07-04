package com.example.cobajpa.DAO;

import java.util.List;

import com.example.cobajpa.model.Login;

public interface LoginDAO {
	public List<Login> getAllLogin();
	public Login getByIdLogin(long id);
	public void SaveOrUpdateLogin(Login login);
	public void deleteIDLogin(long id);
	public void deleteKaryawan(Login login);
	
	public Login getLogin(String username, String password);
	
	public boolean getExisUsername(String username);
	public boolean getExisPassword(String password);
	
}
