package com.example.cobajpa.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cobajpa.DAO.LoginDAO;
import com.example.cobajpa.model.Login;
import com.example.cobajpa.repository.LoginRepository;

@Service
public class LoginService implements LoginDAO {
	@Autowired
	public LoginRepository loginRepository;

	@Override
	public List<Login> getAllLogin() {
		List <Login> logins= new ArrayList<>();
		loginRepository.findAll().forEach(logins::add);
		return logins;
	}

	@Override
	public Login getByIdLogin(long id) {
		Login login= loginRepository.findById(id).get();
		return login;
	}

	@Override
	public void SaveOrUpdateLogin(Login login) {
		loginRepository.save(login);
		
	}

	@Override
	public void deleteIDLogin(long id) {
		loginRepository.deleteById(id);
		
	}

	@Override
	public void deleteKaryawan(Login login) {
		loginRepository.delete(login);
		
	}

	@Override
	public Login getLogin(String username, String password) {
		return loginRepository.findByUsernameAndPassword(username, password);
	}

	@Override
	public boolean getExisUsername(String username) {
		return loginRepository.findByUsername(username)!=null;
	}
	
	@Override
	public boolean getExisPassword(String password) {
		return loginRepository.findByPassword(password)!=null;
	}
}
