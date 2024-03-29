package com.admin.entities;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class ProjectEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column
	private String proname;
	@Column
	private String proclientname;
	@Column
	private String email;
	@Column
	private int phoneno;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProname() {
		return proname;
	}
	public void setProname(String proname) {
		this.proname = proname;
	}
	public String getProclientname() {
		return proclientname;
	}
	public void setProclientname(String proclientname) {
		this.proclientname = proclientname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getPhoneno() {
		return phoneno;
	}
	public void setPhoneno(int phoneno) {
		this.phoneno = phoneno;
	}
	@Override
	public String toString() {
		return "ProjectEntity [id=" + id + ", proname=" + proname + ", proclientname=" + proclientname + ", email="
				+ email + ", phoneno=" + phoneno + "]";
	}
	public ProjectEntity(int id, String proname, String proclientname, String email, int phoneno) {
		super();
		this.id = id;
		this.proname = proname;
		this.proclientname = proclientname;
		this.email = email;
		this.phoneno = phoneno;
	}
	public ProjectEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	}
