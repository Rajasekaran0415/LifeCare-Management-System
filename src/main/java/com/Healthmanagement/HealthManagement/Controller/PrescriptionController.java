package com.Healthmanagement.HealthManagement.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Healthmanagement.HealthManagement.DTO.Prescription;
import com.Healthmanagement.HealthManagement.Services.PrescriptionServices;

@RestController
@RequestMapping("/prescription")
//@CrossOrigin(origins = "http://127.0.0.1:5500")// allow frontend to call
public class PrescriptionController {
	@Autowired
	PrescriptionServices prescriptionservices;
	@PostMapping("/save")
    public ResponseEntity<Prescription> savePrescription(@RequestBody Prescription prescription) {
        Prescription saved = prescriptionservices.addPrescription(prescription);
        return new ResponseEntity<>(saved, HttpStatus.OK);
    }
	@PostMapping("/generate-image")
    public ResponseEntity<byte[]> getPrescriptionImage(@RequestBody Prescription prescription) {
        try {
            byte[] imageBytes = prescriptionservices.generatePrescriptionImage(prescription, prescription.getName());
            
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.IMAGE_PNG);
            
            return new ResponseEntity<>(imageBytes, headers, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
	

    }
}
