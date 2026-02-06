package com.Healthmanagement.HealthManagement.DAO;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Healthmanagement.HealthManagement.DTO.Appointments;

import com.Healthmanagement.HealthManagement.Repository.AppointmentRepo;

@Repository
public class AppointmentsDAO {

	    @Autowired
	    private AppointmentRepo repo;

	    // Save patient (bookAppointment)
	    public Appointments saveappointment(Appointments appointment) {
	        return repo.save(appointment);
	    }
	    
	    public Appointments findByPatientName(String PatientName) {
	        Optional<Appointments> appointment = Optional.of(repo.findByPatientName(PatientName));
	        if (appointment.isPresent()) {
	            return appointment.get();
	        }
	        return null; 
	    }
	    public List<Appointments> getAllAppointments() {
	    	return repo.findAll();
	    }
	   
}
