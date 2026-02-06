package com.Healthmanagement.HealthManagement.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.Healthmanagement.HealthManagement.DAO.AppointmentsDAO;

import com.Healthmanagement.HealthManagement.DTO.Appointments;

@Component
public class AppointmentServices {
	@Autowired
		AppointmentsDAO dao;
		public Appointments saveappointment(Appointments appointment) {
			return dao.saveappointment(appointment);
		
		}
		public List<Appointments> getAll() {
//	        List<Appointments> appointments = repo.findAll();
	        
	        
	        
	        return dao.getAllAppointments();
	    }

}
