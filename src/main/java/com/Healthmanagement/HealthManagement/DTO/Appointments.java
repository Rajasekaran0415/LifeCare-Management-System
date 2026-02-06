package com.Healthmanagement.HealthManagement.DTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
	public class Appointments {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int id;
	    private String hospitalName;
	    public String getHospitalName() {
			return hospitalName;
		}

		public void setHospitalName(String hospitalName) {
			this.hospitalName = hospitalName;
		}

		private String patientName;
	    private String doctorName;
	    private String appointmentDate;
	    private String appointmentTime;

	    // Getters and Setters
	    public int getId() {
	        return id;
	    }

	    public void setId(int id) {
	        this.id = id;
	    }

	    public String getPatientName() {
	        return patientName;
	    }

	    public void setPatientName(String patientName) {
	        this.patientName = patientName;
	    }

	    public String getDoctorName() {
	        return doctorName;
	    }

	    public void setDoctorName(String doctorName) {
	        this.doctorName = doctorName;
	    }

	    public String getAppointmentDate() {
	        return appointmentDate;
	    }

	    public void setAppointmentDate(String appointmentDate) {
	        this.appointmentDate = appointmentDate;
	    }

	    public String getAppointmentTime() {
	        return appointmentTime;
	    }

	    public void setAppointmentTime(String appointmentTime) {
	        this.appointmentTime = appointmentTime;
	    }

		
		public Appointments(int id, String hospitalName, String patientName, String doctorName, String appointmentDate,
				String appointmentTime) {
			super();
			this.id = id;
			this.hospitalName = hospitalName;
			this.patientName = patientName;
			this.doctorName = doctorName;
			this.appointmentDate = appointmentDate;
			this.appointmentTime = appointmentTime;
		}

		public Appointments() {
			super();
		}

		@Override
		public String toString() {
			return "Appointments [id=" + id + ", hospitalName=" + hospitalName + ", patientName=" + patientName
					+ ", doctorName=" + doctorName + ", appointmentDate=" + appointmentDate + ", appointmentTime="
					+ appointmentTime + "]";
		}
	    
	}





