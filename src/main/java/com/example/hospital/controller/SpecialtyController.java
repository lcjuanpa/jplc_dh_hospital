package com.example.hospital.controller;

import com.example.hospital.domain.Specialty;
import com.example.hospital.repository.SpecialtyRepository;
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
public class SpecialtyController {
  private final SpecialtyRepository repository;

  public SpecialtyController(SpecialtyRepository repository) {
    this.repository = repository;
  }
  
  @GetMapping("/api/specialties")
  List<Specialty> getAll() {
    return repository.findAll();
  }
  
  @PostMapping("/api/specialties")
  Specialty create(@RequestBody Specialty specialty) {
    return repository.save(specialty);
  }
  
  @GetMapping("/api/specialties/{id}")
  Specialty getOne(@PathVariable Long id) {
    return repository.findById(id)
      .orElseThrow(() -> new RuntimeException("Specialty not found: " + id));
  }
  
  @PutMapping("/api/specialties/{id}")
  Specialty replace(@RequestBody Specialty newSpecialty, @PathVariable Long id) {
    Specialty specialty = repository.findById(id)
      .orElseThrow(() -> new RuntimeException("Specialty not found: " + id));
    specialty.setName(newSpecialty.getName());
    specialty.setDescription(newSpecialty.getDescription());
    specialty.setAvatarUrl(newSpecialty.getAvatarUrl());
    return repository.save(specialty);
  }
  
  @DeleteMapping("/api/specialties/{id}")
  void delete(@PathVariable Long id) {
    repository.deleteById(id);
  }
}
