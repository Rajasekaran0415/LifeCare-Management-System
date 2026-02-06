package com.Healthmanagement.HealthManagement.DTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Prescription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String issue;
    
    @jakarta.persistence.OneToOne
    @jakarta.persistence.JoinColumn(name = "appointment_id")
    private Appointments appointment;

    public Appointments getAppointment() {
        return appointment;
    }

    public void setAppointment(Appointments appointment) {
        this.appointment = appointment;
    }
    

    public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIssue() {
		return issue;
	}

	public void setIssue(String issue) {
		this.issue = issue;
	}

	public Prescription() { super(); }
    
    public String getDoctorName() {
        return (appointment != null) ? appointment.getDoctorName() : "No Doctor Assigned";
    }
}