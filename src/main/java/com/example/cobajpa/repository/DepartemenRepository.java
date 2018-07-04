package com.example.cobajpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.cobajpa.model.Departemen;

public interface DepartemenRepository extends CrudRepository<Departemen, Long>{
	@Query(value = "select * from [RO3].[dbo].[departemen] where status='Active'",nativeQuery = true)
    List<Departemen>ListDepartemenByActive();
}
