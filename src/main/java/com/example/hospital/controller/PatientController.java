package com.example.hospital.controller;

import com.example.hospital.domain.Patient;
import com.example.hospital.repository.PatientRepository;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author jplc
 */
@RestController
public class PatientController {
  private final PatientRepository repository;

  public PatientController(PatientRepository repository) {
    this.repository = repository;
  }
  
  @GetMapping("/api/patients") // /api/patients?hid=1
  List<Patient> getAll(@RequestParam(value = "hid") Long hospitalId) {
    return repository.findByHospitalId(hospitalId);
  }
  
  @PostMapping("/api/patients")
  Patient create(@RequestBody Patient patient) {
    return repository.save(patient);
  }
  
  @GetMapping("/api/patients/{id}")
  Patient getOne(@PathVariable Long id) {
    return repository.findById(id)
      .orElseThrow(() -> new RuntimeException("Patient not found: " + id));
  }
  
  @PutMapping("/api/patients/{id}")
  Patient replace(@RequestBody Patient newPatient, @PathVariable Long id) {
    Patient patient = repository.findById(id)
      .orElseThrow(() -> new RuntimeException("Patient not found: " + id));
    patient.setName(newPatient.getName());
    patient.setLastname(newPatient.getLastname());
    patient.setBirthday(newPatient.getBirthday());
    patient.setAddress(newPatient.getAddress());
    patient.setPhotoUrl(newPatient.getPhotoUrl());
    return repository.save(patient);
  }
  
  @DeleteMapping("/api/patients/{id}")
  void delete(@PathVariable Long id) {
    repository.deleteById(id);
  }
}
