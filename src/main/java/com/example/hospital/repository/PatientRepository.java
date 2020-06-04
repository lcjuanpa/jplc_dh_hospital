package com.example.hospital.repository;

import com.example.hospital.domain.Patient;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author jplc
 */
public interface PatientRepository extends JpaRepository<Patient, Long> {
  
  List<Patient> findByName(String name);
  
  List<Patient> findByLastname(String lastname);
  
  List<Patient> findByHospitalId(Long id);
}
