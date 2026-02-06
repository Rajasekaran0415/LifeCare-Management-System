package com.Healthmanagement.HealthManagement.DTO;

import java.sql.Blob;

import org.springframework.boot.autoconfigure.web.WebProperties.Resources.Chain.Strategy;



import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;

@Entity
public class NurseLogin {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	public NurseLogin(int id, String name, String password, String department, Blob idcard) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.department = department;
		this.idcard = idcard;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	private String password;
	private String department;
	@Lob
	private Blob idcard;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public Blob getIdcard() {
		return idcard;
	}
	public void setIdcard(Blob idcard) {
		this.idcard = idcard;
	
	}
	public NurseLogin() {
		super();
	}
	@Override
	public String toString() {
		return "NurseLogin [id=" + id + ", name=" + name + ", password=" + password + ", department=" + department
				+ ", idcard=" + idcard + "]";
	}
	
	

}
