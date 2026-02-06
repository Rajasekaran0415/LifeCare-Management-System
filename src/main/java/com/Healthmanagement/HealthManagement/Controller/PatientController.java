package com.Healthmanagement.HealthManagement.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Healthmanagement.HealthManagement.DTO.Patients;
import com.Healthmanagement.HealthManagement.Services.PatientsServices;



//API Endpoints
@RestController
@RequestMapping("/patients")
@CrossOrigin(origins = "http://127.0.0.1:5500")// allow frontend to call
public class PatientController {
	@Autowired
	PatientsServices service;
	@PostMapping("/savepatient")
	public ResponseEntity<Patients> savepatients(@RequestBody Patients patients) {
		 Patients savepatients=service.savepatient(patients);
		 return new ResponseEntity<Patients>(savepatients, HttpStatus.CREATED);
	}
	@PostMapping("/patientlogin")
	public ResponseEntity<Patients> login(@RequestBody Patients patients) {
	   
	    Patients authenticated = service.login(patients.getName(), patients.getPassword());

	    if (authenticated != null) {

	        return new ResponseEntity<>(authenticated, HttpStatus.OK);
	    } else {

	        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
	    }
	}
	
	@GetMapping("/report/{patientid}")
	public ResponseEntity<byte[]> getPatientReport(@PathVariable int patientid) {
	    try {
	        // Use the corrected variable name
	        byte[] pdfBytes = service.generatePatientReportPDF(patientid); 

	        HttpHeaders headers = new HttpHeaders();
	        headers.setContentType(MediaType.APPLICATION_PDF);
	        // Use the corrected variable name in the filename
	        headers.setContentDispositionFormData("attachment", "Patient_Report_" + patientid + ".pdf"); 
	        headers.setContentLength(pdfBytes.length);

	        return new ResponseEntity<>(
	            pdfBytes,
	            headers,
	            HttpStatus.OK
	        );

	    } catch (Exception e) {
	        e.printStackTrace();
	        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}
}