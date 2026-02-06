package com.Healthmanagement.HealthManagement.Controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.Healthmanagement.HealthManagement.DTO.Hospital;
import com.Healthmanagement.HealthManagement.Services.HospitalService;

//@CrossOrigin(origins="http://127.0.0.1:5500")
@RestController
//@RequestMapping("/hospital")
public class HospitalController {

    @Autowired
    private HospitalService service;

    @PostMapping("/addhospitals")
    public ResponseEntity<Hospital> addhospital(@RequestBody Hospital hospital) {
        Hospital savehospital = service.addHospital(hospital);
        return new ResponseEntity<>(savehospital, HttpStatus.CREATED);
    }

    @GetMapping("/hospital")
    public ResponseEntity<List<Hospital>> getAllHospitals() {
        return ResponseEntity.ok(service.findall());
    }
}
