package com.Healthmanagement.HealthManagement.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Healthmanagement.HealthManagement.DTO.Hospital;
import com.Healthmanagement.HealthManagement.Repository.HospitalRepo;


	@Repository
	public class HospitalDAO {

		    @Autowired
		    private HospitalRepo repo;

		    
		    public Hospital savehospital(Hospital hospital) {
		        return repo.save(hospital);
		    }
		    public List<Hospital> findall(){
				return repo.findAll();
		    	
		    }

	}


