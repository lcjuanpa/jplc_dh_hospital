package com.example.hospital.controller;

import com.example.hospital.domain.Doctor;
import com.example.hospital.repository.DoctorRepository;
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
public class DoctorController {
  private final DoctorRepository repository;

  public DoctorController(DoctorRepository repository) {
    this.repository = repository;
  }
  
  @GetMapping("/api/doctors") // /api/doctors?hid=2
  List<Doctor> getAll(@RequestParam(value = "hid") Long hospitalId) {
    return repository.findByHospitalId(hospitalId);
  }
  
  @GetMapping("/api/doctors/findByName") // /api/doctors?hid=1
  List<Doctor> getAllByName(@RequestParam(value = "name") String name) {
    return repository.findByName(name);
  }
  
  @GetMapping("/api/doctors/findByLastname") // /api/doctors?hid=1
  List<Doctor> getAllByLastname(@RequestParam(value = "lastname") String lastname) {
    return repository.findByLastname(lastname);
  }
  
  @PostMapping("/api/doctors")
  Doctor create(@RequestBody Doctor doctor) {
    return repository.save(doctor);
  }
  
  @GetMapping("/api/doctors/{id}")
  Doctor getOne(@PathVariable Long id) {
    return repository.findById(id)
      .orElseThrow(() -> new RuntimeException("Doctor not found: " + id));
  }
  
  @PutMapping("/api/doctors/{id}")
  Doctor replace(@RequestBody Doctor newDoctor, @PathVariable Long id) {
    Doctor doctor = repository.findById(id)
      .orElseThrow(() -> new RuntimeException("Doctor not found: " + id));
    doctor.setName(newDoctor.getName());
    doctor.setLastname(newDoctor.getLastname());
    doctor.setBirthday(newDoctor.getBirthday());
    doctor.setAddress(newDoctor.getAddress());
    doctor.setPhotoUrl(newDoctor.getPhotoUrl());
    return repository.save(doctor);
  }
  
  @DeleteMapping("/api/doctors/{id}")
  void delete(@PathVariable Long id) {
    repository.deleteById(id);
  }
}
