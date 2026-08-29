package com.Healthmanagement.HealthManagement.DTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Patients {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String loginId;
	private String name;
	private String password;
	private String gender;
	private int age;
	private int weight;
	private String bloodgroup;

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public  String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getBloodgroup() {
		return bloodgroup;
	}

	public void setBloodgroup(String bloodgroup) {
		this.bloodgroup = bloodgroup;
	}

	public Patients(int id, String loginId, String name, String password, String gender, int age, int weight,
			String bloodgroup) {
		super();
		this.id = id;
		this.loginId = loginId;
		this.name = name;
		this.password = password;
		this.gender = gender;
		this.age = age;
		this.weight = weight;
		this.bloodgroup = bloodgroup;
	}

	public Patients() {
		super();
	}

	@Override
	public String toString() {
		return "Patients [id=" + id + ", loginId=" + loginId + ", name=" + name + ", password=" + password
				+ ", gender=" + gender + ", age=" + age + ", weight=" + weight + ", bloodgroup=" + bloodgroup + "]";
	}

}
