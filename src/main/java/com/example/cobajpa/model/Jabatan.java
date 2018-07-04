package com.example.cobajpa.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Jabatan {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idJabatan;
	
	
	 public boolean isSelected(Long idJabatan) {
    	if (idJabatan==this.idJabatan) {
			return true;
		}else {
			return false;
		}
    }
    @Column(length = 25)
    private String namaJabatan;
    @OneToMany(mappedBy = "jabatan")
    @JsonIgnore
    private List<Karyawan> karyawans;

    public Jabatan() {
    }

    public Jabatan(Long idJabatan, String namaJabatan) {
        this.idJabatan = idJabatan;
        this.namaJabatan = namaJabatan;
    }

    public Long getId() {
        return getIdJabatan();
    }

    public void setId(Long id) {
        this.setIdJabatan(id);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (getIdJabatan() != null ? getIdJabatan().hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Jabatan)) {
            return false;
        }
        Jabatan other = (Jabatan) object;
        if ((this.getIdJabatan() == null && other.getIdJabatan() != null) || (this.getIdJabatan() != null && !this.idJabatan.equals(other.idJabatan))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Jabatan[ id=" + getIdJabatan() + " ]";
    }

    /**
     * @return the idJabatan
     */
    public Long getIdJabatan() {
        return idJabatan;
    }

    /**
     * @param idJabatan the idJabatan to set
     */
    public void setIdJabatan(Long idJabatan) {
        this.idJabatan = idJabatan;
    }

    /**
     * @return the namaJabatan
     */
    public String getNamaJabatan() {
        return namaJabatan;
    }

    /**
     * @param namaJabatan the namaJabatan to set
     */
    public void setNamaJabatan(String namaJabatan) {
        this.namaJabatan = namaJabatan;
    }

    public List<Karyawan> getKaryawans() {
        return karyawans;
    }

    public void setKaryawans(List<Karyawan> karyawans) {
        this.karyawans = karyawans;
    }

}
