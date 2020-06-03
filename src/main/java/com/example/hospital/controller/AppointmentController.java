package com.example.hospital.controller;

import com.example.hospital.domain.Appointment;
import com.example.hospital.repository.AppointmentRepository;
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
public class AppointmentController {
  private final AppointmentRepository repository;

  public AppointmentController(AppointmentRepository repository) {
    this.repository = repository;
  }
  
  @GetMapping("/api/appointments")
  List<Appointment> getAll() {
    return repository.findAll();
  }
  
  @PostMapping("/api/appointments")
  Appointment create(@RequestBody Appointment appointment) {
    return repository.save(appointment);
  }
  
  @GetMapping("/api/appointments/{id}")
  Appointment getOne(@PathVariable Long id) {
    return repository.findById(id)
      .orElseThrow(() -> new RuntimeException("Appointment not found: " + id));
  }
  
  @PutMapping("/api/appointments/{id}")
  Appointment replace(@RequestBody Appointment newAppointment, @PathVariable Long id) {
    Appointment appointment = repository.findById(id)
      .orElseThrow(() -> new RuntimeException("Appointment not found: " + id));
    appointment.setDescription(newAppointment.getDescription());
    appointment.setDateTime(newAppointment.getDateTime());
    return repository.save(appointment);
  }
  
  @DeleteMapping("/api/appointments/{id}")
  void delete(@PathVariable Long id) {
    repository.deleteById(id);
  }
}
