package com.Healthmanagement.HealthManagement.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.Healthmanagement.HealthManagement.DTO.NurseLogin;
import com.Healthmanagement.HealthManagement.Repository.NurseLoginRepo;

@Repository
public class NurseLoginDAO {
	@Autowired
	NurseLoginRepo repo;
	
	public NurseLogin savenurse(NurseLogin nurselogin) {
		return repo.save(nurselogin);
		
		}
	public NurseLogin login(String name, String Password) {
		return repo.findByNameAndPassword(name,Password);
		
	} 
	

}
