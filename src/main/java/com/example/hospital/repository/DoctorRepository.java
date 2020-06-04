package com.example.hospital.repository;

import com.example.hospital.domain.Doctor;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author jplc
 */
public interface DoctorRepository extends JpaRepository<Doctor, Long>{
  
  List<Doctor> findByName(String name);
  
  List<Doctor> findByLastname(String lastname);
  
  List<Doctor> findByHospitalId(Long id);
}
