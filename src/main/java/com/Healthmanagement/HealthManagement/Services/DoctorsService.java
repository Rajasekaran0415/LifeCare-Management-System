package com.Healthmanagement.HealthManagement.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.Healthmanagement.HealthManagement.DAO.DoctorsDao;
import com.Healthmanagement.HealthManagement.DTO.Doctors;

@Component
public class DoctorsService {
	@Autowired
	DoctorsDao dao;
	public Doctors addDoctors(Doctors doctors) {
		return dao.savedoctors(doctors);
		
		
	}
	public List<Doctors> findall(){
		return dao.findall();
		
	}
	

}
