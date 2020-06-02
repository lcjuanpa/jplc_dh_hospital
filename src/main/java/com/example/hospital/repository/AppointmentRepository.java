package com.example.hospital.repository;

import com.example.hospital.domain.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author jplc
 */
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
  
}
