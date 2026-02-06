package com.Healthmanagement.HealthManagement.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Healthmanagement.HealthManagement.DTO.Patients;

public interface PatientRepo extends JpaRepository<Patients, Integer> {
	    Patients findByNameAndPassword(String name, String password); 
	    Patients findPatientsById(Integer id);
		
	}

