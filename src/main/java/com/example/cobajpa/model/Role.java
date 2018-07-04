package com.example.cobajpa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Role {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	
	@Column(length=10)
	private String namaRole;
	
	public Role() {
		// TODO Auto-generated constructor stub
	}
	
	public Role(Long id, String namaRole) {
		this.id = id;
		this.namaRole = namaRole;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNamaRole() {
		return namaRole;
	}

	public void setNamaRole(String namaRole) {
		this.namaRole = namaRole;
	}
	
	
}
