package com.Healthmanagement.HealthManagement.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Healthmanagement.HealthManagement.DTO.Hospital;

public interface HospitalRepo extends JpaRepository<Hospital, Long> {

}
