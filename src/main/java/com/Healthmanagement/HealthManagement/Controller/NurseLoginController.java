package com.Healthmanagement.HealthManagement.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Healthmanagement.HealthManagement.DTO.NurseLogin;
import com.Healthmanagement.HealthManagement.DTO.Patients;
import com.Healthmanagement.HealthManagement.Services.NurseLoginService;



@RestController
@RequestMapping("/nurselogin")
@CrossOrigin(origins="http://127.0.0.1:5500")
public class NurseLoginController {
	@Autowired
	private NurseLoginService nurseloginservice;
	@PostMapping("/saveNurse")
	public ResponseEntity<NurseLogin> addNurse(NurseLogin nurselogin){
		NurseLogin savenurse=nurseloginservice.addNurse(nurselogin);
		return new ResponseEntity<NurseLogin>(savenurse,HttpStatus.OK);
	}
	@PostMapping("/nurseLogin")
	public ResponseEntity<NurseLogin> login(@RequestBody NurseLogin nurselogin) {
	   
	    NurseLogin authenticated = nurseloginservice.addNurseLogin(nurselogin.getName(),nurselogin.getPassword());
	 

	    if (authenticated != null) {

	        return new ResponseEntity<>(authenticated, HttpStatus.OK);
	    } else {

	        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
	    }
	}

}
