package com.example.cobajpa.model;



import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Karyawan extends Additional {
	/*private static final long serialVersionUID = 1L;*/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idKaryawan;
    
    public boolean isSelected(Long idKaryawan) {
    	if (idKaryawan==this.idKaryawan) {
			return true;
		}else {
			return false;
		}
    }
    
    
    @Column(length = 30)
    private String namaLengkap;

    @Column(length = 20)
    private Integer noKTP;

    @Column(length = 10)
    private String jenisKelamin;

    @Column(length = 20)
    private String tempatLahir;

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date tanggalLahir;

    @Column(length = 10)
    private String agama;

    @Column(length = 10)
    private String statusPerkawinan;

    @Column(length = 10)
    private String kewarganegaraan;

    @Column(length = 30)
    private String pendidikan;
    
    @Column(length = 30)
    private String email;
    
    @Column(length = 30)
    private String hp;
    
    @Column(length = 100)
    private String photoUser;
    
    @ManyToOne
    private Jabatan jabatan;
    
    @ManyToOne
    private Departemen departemen;
    
    public void setDepartemen(Departemen departemen) {
		this.departemen = departemen;
	}

	@OneToOne(mappedBy = "penilai")
    @JsonIgnore
    private Departemen departemenKaryawan;

  


	@OneToOne(mappedBy = "karyawan")
	@JsonIgnore
    private Login login;

    @OneToMany(mappedBy = "karyawan")
    @JsonIgnore
    private List<Alamat> alamats;
    
    

  

	public Karyawan(String photoUser) {
		this.photoUser = photoUser;
	}

	public Karyawan() {
    }

	public Long getIdKaryawan() {
		return idKaryawan;
	}

	public void setIdKaryawan(Long idKaryawan) {
		this.idKaryawan = idKaryawan;
	}

	public String getNamaLengkap() {
		return namaLengkap;
	}

	public void setNamaLengkap(String namaLengkap) {
		this.namaLengkap = namaLengkap;
	}

	public Integer getNoKTP() {
		return noKTP;
	}

	public void setNoKTP(Integer noKTP) {
		this.noKTP = noKTP;
	}

	public String getJenisKelamin() {
		return jenisKelamin;
	}

	public void setJenisKelamin(String jenisKelamin) {
		this.jenisKelamin = jenisKelamin;
	}

	public String getTempatLahir() {
		return tempatLahir;
	}

	public void setTempatLahir(String tempatLahir) {
		this.tempatLahir = tempatLahir;
	}


	public String getAgama() {
		return agama;
	}

	public void setAgama(String agama) {
		this.agama = agama;
	}

	public String getStatusPerkawinan() {
		return statusPerkawinan;
	}

	public void setStatusPerkawinan(String statusPerkawinan) {
		this.statusPerkawinan = statusPerkawinan;
	}

	public String getKewarganegaraan() {
		return kewarganegaraan;
	}

	public void setKewarganegaraan(String kewarganegaraan) {
		this.kewarganegaraan = kewarganegaraan;
	}

	public String getPendidikan() {
		return pendidikan;
	}

	public void setPendidikan(String pendidikan) {
		this.pendidikan = pendidikan;
	}

	public Jabatan getJabatan() {
		return jabatan;
	}

	public void setJabatan(Jabatan jabatan) {
		this.jabatan = jabatan;
	}

	public Departemen getDepartemen() {
		return departemen;
	}
//
	



	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

	public List<Alamat> getAlamats() {
		return alamats;
	}

	public void setAlamats(List<Alamat> alamats) {
		this.alamats = alamats;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getHp() {
		return hp;
	}

	public void setHp(String hp) {
		this.hp = hp;
	}

	public Departemen getDepartemenKaryawan() {
		return departemenKaryawan;
	}

	public void setDepartemenKaryawan(Departemen departemenKaryawan) {
		this.departemenKaryawan = departemenKaryawan;
	}

	public String getPhotoUser() {
		return photoUser;
	}

	public void setPhotoUser(String photoUser) {
		this.photoUser = photoUser;
	}

	public Date getTanggalLahir() {
		return tanggalLahir;
	}

	public void setTanggalLahir(Date tanggalLahir) {
		this.tanggalLahir = tanggalLahir;
	}

	
    
   
}
