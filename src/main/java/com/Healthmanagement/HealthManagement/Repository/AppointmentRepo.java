package com.Healthmanagement.HealthManagement.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Healthmanagement.HealthManagement.DTO.Appointments;



public interface AppointmentRepo extends JpaRepository<Appointments, Integer>{

	Appointments findByPatientName(String PatientName);
	

}
