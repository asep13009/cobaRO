package com.example.cobajpa.model;

import java.util.Date;

import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;

@MappedSuperclass
public abstract class Additional {
	   @Temporal(javax.persistence.TemporalType.DATE)
	    private Date createDate; 
	    @Temporal(javax.persistence.TemporalType.DATE)
	    private Date updateDate;
	    private String createBy;
	    private String updateBy;
	    private String status;
	    private String keterangan;
	    
	    public Additional() {
			// TODO Auto-generated constructor stub
		}

		public Additional(Date createDate, Date updateDate, String createBy, String updateBy, String status,
				String keterangan) {
			this.createDate = createDate;
			this.updateDate = updateDate;
			this.createBy = createBy;
			this.updateBy = updateBy;
			this.status = status;
			this.keterangan = keterangan;
		}

		public Date getCreateDate() {
			return createDate;
		}

		public void setCreateDate(Date createDate) {
			this.createDate = createDate;
		}

		public Date getUpdateDate() {
			return updateDate;
		}

		public void setUpdateDate(Date updateDate) {
			this.updateDate = updateDate;
		}

		public String getCreateBy() {
			return createBy;
		}

		public void setCreateBy(String createBy) {
			this.createBy = createBy;
		}

		public String getUpdateBy() {
			return updateBy;
		}

		public void setUpdateBy(String updateBy) {
			this.updateBy = updateBy;
		}

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}

		public String getKeterangan() {
			return keterangan;
		}

		public void setKeterangan(String keterangan) {
			this.keterangan = keterangan;
		}
	    
}
