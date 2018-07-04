package com.example.cobajpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.cobajpa.model.Wilayah;

public interface WilayahRepository extends CrudRepository<Wilayah, Long> {
	List<Wilayah> findByLevel(Integer level);
	
	@Query (value="SELECT * FROM wilayah WHERE level=:level and wilayah_id_wilayah=:idWilayah",nativeQuery=true)
	List<Wilayah> getByLevelParent(@Param("level")int level,@Param("idWilayah") long id);


}
