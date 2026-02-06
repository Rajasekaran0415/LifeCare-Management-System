package com.Healthmanagement.HealthManagement.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Healthmanagement.HealthManagement.DTO.Patients;
import com.Healthmanagement.HealthManagement.Repository.PatientRepo;



@Repository
public class PatientsDAO {

    @Autowired
    private PatientRepo repo;

    // Save patient (signup)
    public Patients savepatient(Patients patients) {
        return repo.save(patients);
    }

	public Patients login(String name, String password) {
		
		return repo.findByNameAndPassword(name, password);
	}
	public Patients findPatientById(int id) {
		return repo.findPatientsById(id);
	}

}
    
