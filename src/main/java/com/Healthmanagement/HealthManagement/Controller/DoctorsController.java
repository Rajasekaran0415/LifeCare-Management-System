package com.Healthmanagement.HealthManagement.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Healthmanagement.HealthManagement.DTO.Doctors;

import com.Healthmanagement.HealthManagement.Services.DoctorsService;

@RestController
@RequestMapping("/doctors")
@CrossOrigin(origins="http://127.0.0.1:5500")
public class DoctorsController {
	@Autowired
	private DoctorsService ds;
	@PostMapping("/adddoctors")
	public ResponseEntity<Doctors> addhospital(@RequestBody Doctors doctors) {
	Doctors savedoctor = ds.addDoctors(doctors);
		 return new ResponseEntity<Doctors>(savedoctor, HttpStatus.CREATED);
	}

	@GetMapping("/byHospital/{hospitalId}")
	
    public List<Doctors> getAllDoctors() {
        
        return ds.findall();
    }

}
