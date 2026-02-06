package com.Healthmanagement.HealthManagement.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Healthmanagement.HealthManagement.DTO.Doctors;

public interface DoctorsRepo extends JpaRepository<Doctors, Integer> {

}
