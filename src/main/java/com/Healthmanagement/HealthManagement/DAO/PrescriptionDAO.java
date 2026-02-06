package com.Healthmanagement.HealthManagement.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Healthmanagement.HealthManagement.DTO.Prescription;
import com.Healthmanagement.HealthManagement.Repository.PrescriptionRepo;

@Repository
public class PrescriptionDAO {
	@Autowired
	private PrescriptionRepo repo;
	
	
	public Prescription savePrescription(Prescription prescription) {
		return repo.save(prescription);
	}
	

}
