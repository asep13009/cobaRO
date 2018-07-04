package com.example.cobajpa.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cobajpa.DAO.RoleDAO;
import com.example.cobajpa.model.Role;
import com.example.cobajpa.repository.RoleRepository;

@Service
public class RoleService implements RoleDAO {
	
	@Autowired
	RoleRepository roleRepository;

	@Override
	public List<Role> getAllRole() {
		List <Role> roles= new ArrayList<>();
		roleRepository.findAll().forEach(roles::add);
		return roles;
	}

	@Override
	public Role getByIdRole(long id) {
		Role role= roleRepository.findById(id).get();
		return role;
	}

	@Override
	public void SaveOrUpdateRole(Role role) {
		roleRepository.save(role);
		
	}

	@Override
	public void deleteIDRole(long id) {
		roleRepository.deleteById(id);
		
	}

	@Override
	public void deleteRole(Role role) {
		roleRepository.delete(role);
		
	}
	
}
