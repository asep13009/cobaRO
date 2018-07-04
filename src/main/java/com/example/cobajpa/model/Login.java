package com.example.cobajpa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Login {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idLogin;

    @Column(length = 25, unique = true)
    private String username;

    private String password;
    
   @ManyToOne
   private Role role;

    @OneToOne
    @JsonIgnore
    private Karyawan karyawan;

    public Login(Long idLogin, String username, String password, Karyawan karyawan) {
        this.idLogin = idLogin;
        this.username = username;
        this.password = password;
        this.karyawan = karyawan;
    }

    public Login() {
    }

    public Login(Long idLogin, String username, String password) {
        this.idLogin = idLogin;
        this.username = username;
        this.password = password;
    }
    
    
    
	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Long getId() {
        return getIdLogin();
    }
	
    public void setId(Long id) {
        this.setIdLogin(id);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (getIdLogin() != null ? getIdLogin().hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Login)) {
            return false;
        }
        Login other = (Login) object;
        if ((this.getIdLogin() == null && other.getIdLogin() != null) || (this.getIdLogin() != null && !this.idLogin.equals(other.idLogin))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Login[ id=" + getIdLogin() + " ]";
    }

    /**
     * @return the idLogin
     */
    public Long getIdLogin() {
        return idLogin;
    }

    /**
     * @param idLogin the idLogin to set
     */
    public void setIdLogin(Long idLogin) {
        this.idLogin = idLogin;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    public Karyawan getKaryawan() {
        return karyawan;
    }

    public void setKaryawan(Karyawan karyawan) {
        this.karyawan = karyawan;
    }

}
