package com.Healthmanagement.HealthManagement.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.Healthmanagement.HealthManagement.DAO.NurseLoginDAO;
import com.Healthmanagement.HealthManagement.DTO.NurseLogin;

@Service
public class NurseLoginService {
	@Autowired
	private NurseLoginDAO nurselogindao;
	
	public NurseLogin addNurse(NurseLogin nurselogin) {
		return nurselogindao.savenurse(nurselogin);
		
	}

	public NurseLogin addNurseLogin(String name, String password) {
		
		return nurselogindao.login(name, password);
	}
	

}
