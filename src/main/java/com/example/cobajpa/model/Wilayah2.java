package com.example.cobajpa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Wilayah2 {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	
	@Column(length = 100)
	private String kode;
	@Column(length = 100)
	private String nama;

	
	public Wilayah2() {
		// TODO Auto-generated constructor stub
	}
	public Wilayah2(long id, String kode, String nama) {
		this.id = id;
		this.kode = kode;
		this.nama = nama;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getKode() {
		return kode;
	}

	public void setKode(String kode) {
		this.kode = kode;
	}

	public String getNama() {
		return nama;
	}

	public void setNama(String nama) {
		this.nama = nama;
	}
	
	

}
