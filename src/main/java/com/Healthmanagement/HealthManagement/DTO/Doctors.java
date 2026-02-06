package com.Healthmanagement.HealthManagement.DTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Doctors {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String specialization;
    private String hospital;

    // Constructors
    public Doctors() {}
    public Doctors(String name, String specialization, String hospital) {
        this.name = name;
        this.specialization = specialization;
        this.hospital = hospital;
    }

    // Getters & Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getSpecialization() { return specialization; }
    public void setSpecialization(String specialization) { this.specialization = specialization; }

    public String getHospital() { return hospital; }
    public void setHospital(String hospital) { this.hospital = hospital; }

    @Override
    public String toString() {
        return "Doctors [id=" + id + ", name=" + name + ", specialization=" + specialization + ", hospital=" + hospital + "]";
    }
}
