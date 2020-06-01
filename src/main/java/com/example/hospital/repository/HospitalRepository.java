package com.example.hospital.repository;

import com.example.hospital.domain.Hospital;
import java.time.LocalDateTime;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author jplc
 */
public interface HospitalRepository extends JpaRepository<Hospital, Long>{
  
  Hospital findByName(String name);
  
  Hospital findByCreatedOn(LocalDateTime createdOn);
}
