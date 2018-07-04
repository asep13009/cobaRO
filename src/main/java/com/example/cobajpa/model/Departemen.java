package com.example.cobajpa.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Departemen extends Additional {
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long idDepartemen;
	    
	    public boolean isSelected(Long idDepartemen) {
	    	if (idDepartemen==this.idDepartemen) {
				return true;
			}else {
				return false;
			}
	    }
	    
	    @Column(length = 20)
	    private String namaDepartemen;
	    
	    @OneToOne
	    @JsonIgnore
	    private Karyawan penilai;
	    
	    @OneToMany(mappedBy="departemen")
	    @JsonIgnore
	    private List<Karyawan> karyawans;

	    public Departemen() {
	    }

	    public Departemen(Long idDepartemen, String namaDepartemen) {
	        this.idDepartemen = idDepartemen;
	        this.namaDepartemen = namaDepartemen;
	    }

	    public Long getId() {
	        return getIdDepartemen();
	    }

	    public void setId(Long id) {
	        this.setIdDepartemen(id);
	    }

	    @Override
	    public int hashCode() {
	        int hash = 0;
	        hash += (getIdDepartemen() != null ? getIdDepartemen().hashCode() : 0);
	        return hash;
	    }

	    @Override
	    public boolean equals(Object object) {
	        // TODO: Warning - this method won't work in the case the id fields are not set
	        if (!(object instanceof Departemen)) {
	            return false;
	        }
	        Departemen other = (Departemen) object;
	        if ((this.getIdDepartemen() == null && other.getIdDepartemen() != null) || (this.getIdDepartemen() != null && !this.idDepartemen.equals(other.idDepartemen))) {
	            return false;
	        }
	        return true;
	    }

	    @Override
	    public String toString() {
	        return "model.Departemen[ id=" + getIdDepartemen() + " ]";
	    }

	    /**
	     * @return the idDepartemen
	     */
	    public Long getIdDepartemen() {
	        return idDepartemen;
	    }

	    /**
	     * @param idDepartemen the idDepartemen to set
	     */
	    public void setIdDepartemen(Long idDepartemen) {
	        this.idDepartemen = idDepartemen;
	    }

	    /**
	     * @return the namaDepartemen
	     */
	    public String getNamaDepartemen() {
	        return namaDepartemen;
	    }

	    /**
	     * @param namaDepartemen the namaDepartemen to set
	     */
	    public void setNamaDepartemen(String namaDepartemen) {
	        this.namaDepartemen = namaDepartemen;
	    }
//
	    public List<Karyawan> getKaryawans() {
	        return karyawans;
	    }
//
	    public void setKaryawans(List<Karyawan> karyawans) {
	      this.karyawans = karyawans;
	    }

	    public Karyawan getPenilai() {
	        return penilai;
	    }

	    public void setPenilai(Karyawan penilai) {
	        this.penilai = penilai;
	    }
}
