package com.Healthmanagement.HealthManagement.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Healthmanagement.HealthManagement.DTO.Doctors;
import com.Healthmanagement.HealthManagement.DTO.Hospital;
import com.Healthmanagement.HealthManagement.Repository.DoctorsRepo;
import com.Healthmanagement.HealthManagement.Repository.HospitalRepo;

@Repository
public class DoctorsDao {
	@Autowired
    private DoctorsRepo repo;

    
    public Doctors savedoctors(Doctors doctor) {
        return repo.save(doctor);
    }
    public List<Doctors> findall(){
		return repo.findAll();
    	
    }

}
