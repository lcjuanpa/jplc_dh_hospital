package com.example.hospital.repository;

import com.example.hospital.domain.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author jplc
 */
public interface DoctorRepository extends JpaRepository<Doctor, Long>{
  
  Doctor findByName(String name);
  
  Doctor findByLastname(String lastname);
}
