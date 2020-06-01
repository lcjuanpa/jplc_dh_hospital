package com.example.hospital;

import com.example.hospital.domain.Hospital;
import com.example.hospital.domain.User;
import com.example.hospital.repository.HospitalRepository;
import com.example.hospital.repository.UserRepository;
import java.time.LocalDateTime;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 *
 * @author jplc
 */
@Component
public class DatabasePopulator implements CommandLineRunner {
  
  private final UserRepository userRepository;
  private final HospitalRepository hospitalRepository;

  public DatabasePopulator(UserRepository userRepository, HospitalRepository hospitalRepository) {
    this.userRepository = userRepository;
    this.hospitalRepository = hospitalRepository;
  }

  @Override
  public void run(String... args) throws Exception {
    User userAdmin = new User("user", "user", "administrator");
    userRepository.save(userAdmin);
    
    Hospital hospital1 = new Hospital("Hospital No. 1", LocalDateTime.now(), userAdmin);
    hospitalRepository.save(hospital1);
    Hospital hospital2 = new Hospital("Hospital No. 2", LocalDateTime.now(), userAdmin);
    hospitalRepository.save(hospital2);
  }
  
}
