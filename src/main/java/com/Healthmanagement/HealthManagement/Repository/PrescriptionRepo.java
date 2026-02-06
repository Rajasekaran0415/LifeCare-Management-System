package com.Healthmanagement.HealthManagement.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Healthmanagement.HealthManagement.DTO.Prescription;
@Repository

public interface PrescriptionRepo extends JpaRepository<Prescription, Long> {




}
