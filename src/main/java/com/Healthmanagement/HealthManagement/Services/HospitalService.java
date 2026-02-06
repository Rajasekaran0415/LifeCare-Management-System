package com.Healthmanagement.HealthManagement.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.Healthmanagement.HealthManagement.DAO.HospitalDAO;
import com.Healthmanagement.HealthManagement.DTO.Hospital;


	@Service
	public class HospitalService {
		@Autowired
			private HospitalDAO dao;
			public Hospital addHospital(Hospital hospital) {
				return dao.savehospital(hospital);
			
			}
			public List<Hospital> findall(){
				return dao.findall();
				
				
			}

	}



