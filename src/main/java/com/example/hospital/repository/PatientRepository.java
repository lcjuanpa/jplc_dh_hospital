package com.example.hospital.repository;

import com.example.hospital.domain.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author jplc
 */
public interface PatientRepository extends JpaRepository<Patient, Long> {
  
  Patient findByName(String name);
  
  Patient findByLastname(String lastname);
}
