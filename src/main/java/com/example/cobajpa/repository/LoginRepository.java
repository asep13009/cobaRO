package com.example.cobajpa.repository;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.cobajpa.model.Login;

@Repository
public interface LoginRepository extends CrudRepository<Login, Long> {
//	List<Login> findByName(String name);
//	List<Login> findPersonDistinctByName(String name);
//	List<Login> findPersonOrderByNameDesc();
	
	
	Login findByUsernameAndPassword(String username, String password);
	
	@Query("select a.username from Login a where a.username=:username")
	public String findByUsername(@Param("username") String username);
	
	@Query("select a.password from Login a where a.password=:password")
	public String findByPassword(@Param("password") String password);
}


