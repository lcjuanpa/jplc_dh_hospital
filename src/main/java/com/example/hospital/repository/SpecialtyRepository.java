package com.example.hospital.repository;

import com.example.hospital.domain.Specialty;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author jplc
 */
public interface SpecialtyRepository extends JpaRepository<Specialty, Long> {
  
}
