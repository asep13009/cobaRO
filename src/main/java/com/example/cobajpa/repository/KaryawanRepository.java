package com.example.cobajpa.repository;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.cobajpa.model.Departemen;
import com.example.cobajpa.model.Karyawan;

public interface KaryawanRepository extends CrudRepository<Karyawan, Long> {
	
	@Query("select a from Karyawan a where a.departemen.id=:id")
	public List<Karyawan> findByIDDepartemen(@Param("id") long id);
	
	public List<Karyawan> findByDepartemen(Departemen byId);
	
	@Query(value = "select * from [RO3].[dbo].[karyawan] where status='Active'",nativeQuery = true)
    List<Karyawan>ListKaryawanByActive();
	
}
