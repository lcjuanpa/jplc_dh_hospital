package com.example.hospital.repository;

import com.example.hospital.domain.User;
import org.springframework.data.repository.Repository;

/**
 *
 * @author jplc
 */
public interface UserRepository extends Repository<User, Long>{
  
  User save(User user);
  
  User findByName(String name);
}
