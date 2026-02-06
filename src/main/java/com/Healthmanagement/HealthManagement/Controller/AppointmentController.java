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

import com.Healthmanagement.HealthManagement.DTO.Appointments;
import com.Healthmanagement.HealthManagement.Services.AppointmentServices;

//API Endpoints
@RestController
@RequestMapping("/appointments")
@CrossOrigin(origins = "http://127.0.0.1:5500") // allow frontend to call
public class AppointmentController {
	@Autowired
	AppointmentServices service;

	@PostMapping("/bookAppointment")
	public ResponseEntity<Appointments> saveappointment(@RequestBody Appointments appointment) {
		Appointments saveappointment = service.saveappointment(appointment);
		return new ResponseEntity<Appointments>(saveappointment, HttpStatus.CREATED);
	}
	@GetMapping("/getall")
    public List<Appointments> getAll() {
        return service.getAll();
    }

}
