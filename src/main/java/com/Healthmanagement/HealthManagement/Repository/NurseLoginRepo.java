package com.Healthmanagement.HealthManagement.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Healthmanagement.HealthManagement.DTO.NurseLogin;
import com.Healthmanagement.HealthManagement.DTO.Patients;

public interface NurseLoginRepo extends JpaRepository<NurseLogin, Integer>{
//	NurseLogin findByNamendPassword(String name, String password);

	NurseLogin findByNameAndPassword(String name, String password); 

}
