package com.example.cobajpa.DAO;

import java.util.List;

import com.example.cobajpa.model.Role;

public interface RoleDAO {
	public List<Role> getAllRole();
	public Role getByIdRole(long id);
	public void SaveOrUpdateRole(Role role);
	public void deleteIDRole(long id);
	public void deleteRole(Role role);
}
