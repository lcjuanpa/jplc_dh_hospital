package com.example.hospital.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import lombok.Data;

/**
 *
 * @author jplc
 */
@Data
@Entity
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  
  @NotBlank(message = "Name is mandatory")
  @Column(nullable = false, unique = true, length = 20)
  private String name;
  
  @JsonIgnore
  @NotBlank(message = "Password is mandatory")
  @Column(nullable = false, length = 128)
  private String password;
  
  private String[] roles;

  public User() {
  }

  public User(String name, String password, String... roles) {
    this.name = name;
    this.password = password;
    this.roles = roles;
  }
}
