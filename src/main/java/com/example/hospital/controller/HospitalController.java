package com.example.hospital.controller;

import com.example.hospital.domain.Hospital;
import com.example.hospital.repository.HospitalRepository;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author jplc
 */
@RestController
public class HospitalController {
  private final HospitalRepository repository;

  public HospitalController(HospitalRepository repository) {
    this.repository = repository;
  }
  
  @GetMapping("/api/hospitals")
  List<Hospital> getAll() {
    return repository.findAll();
  }
  
  @PostMapping("/api/hospitals")
  Hospital create(@RequestBody Hospital hospital) {
    return repository.save(hospital);
  }
  
  @GetMapping("/api/hospitals/{id}")
  Hospital getOne(@PathVariable Long id) {
    return repository.findById(id)
      .orElseThrow(() -> new RuntimeException("Hospital not found: " + id));
  }
  
  @PutMapping("/api/hospitals/{id}")
  Hospital replace(@RequestBody Hospital newHospital, @PathVariable Long id) {
    Hospital hospital = repository.findById(id)
      .orElseThrow(() -> new RuntimeException("Hospital not found: " + id));
    hospital.setName(newHospital.getName());
    return repository.save(hospital);
  }
  
  @DeleteMapping("/api/hospitals/{id}")
  void delete(@PathVariable Long id) {
    repository.deleteById(id);
  }
}
