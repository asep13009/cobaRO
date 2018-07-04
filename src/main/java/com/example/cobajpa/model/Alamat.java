package com.example.cobajpa.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Alamat {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAlamat;

    @ManyToOne
    @JsonIgnore
    private Karyawan karyawan;

    @ManyToOne
    @JsonIgnore
    private Wilayah wilayah;
    
    private String jalan;
    
    public Alamat() {
    }

    public Alamat(Long idAlamat) {
        this.idAlamat = idAlamat;
    }

    public Long getId() {
        return getIdAlamat();
    }

    public void setId(Long id) {
        this.setIdAlamat(id);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (getIdAlamat() != null ? getIdAlamat().hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Alamat)) {
            return false;
        }
        Alamat other = (Alamat) object;
        if ((this.getIdAlamat() == null && other.getIdAlamat() != null) || (this.getIdAlamat() != null && !this.idAlamat.equals(other.idAlamat))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Alamat[ id=" + getIdAlamat() + " ]";
    }

    /**
     * @return the idAlamat
     */
    public Long getIdAlamat() {
        return idAlamat;
    }

    /**
     * @param idAlamat the idAlamat to set
     */
    public void setIdAlamat(Long idAlamat) {
        this.idAlamat = idAlamat;
    }

    public Karyawan getKaryawan() {
        return karyawan;
    }

    public void setKaryawan(Karyawan karyawan) {
        this.karyawan = karyawan;
    }

    public Wilayah getWilayah() {
        return wilayah;
    }

    public void setWilayah(Wilayah wilayah) {
        this.wilayah = wilayah;
    }

	public String getJalan() {
		return jalan;
	}

	public void setJalan(String jalan) {
		this.jalan = jalan;
	}

}
