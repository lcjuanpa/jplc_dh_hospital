package com.example.hospital;

import com.example.hospital.domain.User;
import com.example.hospital.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 *
 * @author jplc
 */
@Component
public class DatabasePopulator implements CommandLineRunner {
  
  private final UserRepository userRepository;

  public DatabasePopulator(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public void run(String... args) throws Exception {
    User userAdmin = new User("user", "user", "administrator");
    userRepository.save(userAdmin);
  }
  
}
