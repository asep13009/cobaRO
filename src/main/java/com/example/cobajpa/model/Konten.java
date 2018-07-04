package com.example.cobajpa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Konten {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(length = 20)
    private String namaKonten;
    @Column(length = 50)
    private String deskripsi;
    
    public Konten() {
		// TODO Auto-generated constructor stub
	}

	

	public Konten(Long id, String namaKonten, String deskripsi) {
		this.id = id;
		this.namaKonten = namaKonten;
		this.deskripsi = deskripsi;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDeskripsi() {
		return deskripsi;
	}

	public void setDeskripsi(String deskripsi) {
		this.deskripsi = deskripsi;
	}

	public String getNamaKonten() {
		return namaKonten;
	}

	public void setNamaKonten(String namaKonten) {
		this.namaKonten = namaKonten;
	}
    

}
