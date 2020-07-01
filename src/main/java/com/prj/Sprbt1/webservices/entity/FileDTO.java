package com.prj.Sprbt1.webservices.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "filetable")
@EntityListeners(AuditingEntityListener.class)
public class FileDTO {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column(name = "f_name", nullable = false)
	private String fname;
	@Column(name = "fp_name", nullable = false)
	private String fpname;  
	@Column(name = "fp_desc", nullable = false , length = 10000)
	private String fpdesc;
	@Column(name = "created_at")      
	@CreatedDate
	private String createdDate;
	@Column(name = "updated_at", nullable = false)
	@LastModifiedDate
	private String modifiedDate;


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getFpname() {
		return fpname;
	}

	public void setFpname(String fpname) {
		this.fpname = fpname;
	}

	public String getFpdesc() {
		return fpdesc;
	}

	public void setFpdesc(String fpdesc) {
		this.fpdesc = fpdesc;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public String getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(String modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	@Override
	public String toString() {
		return "FileDTO [id=" + id + ", fname=" + fname + ", fpname=" + fpname + ", fpdesc=" + fpdesc + ", createdDate="
				+ createdDate + ", modifiedDate=" + modifiedDate + "]";
	}

	public FileDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	

}
