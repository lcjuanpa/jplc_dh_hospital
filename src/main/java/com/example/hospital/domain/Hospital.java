package com.example.hospital.domain;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 *
 * @author jplc
 */
@Data
@Entity
public class Hospital {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  
  @NotBlank(message = "Name is mandatory")
  @Column(nullable = false, unique = true, length = 50)
  private String name;
  
  @NotNull
  @Column(nullable = false)
  private LocalDateTime createdOn;
  
  @NotNull
  @ManyToOne
  @EqualsAndHashCode.Exclude private User createdBy;
  
  @OneToMany(mappedBy = "hospital")
  @EqualsAndHashCode.Exclude private Set<Doctor> doctors = new HashSet<>();
  
  @OneToMany(mappedBy = "hospital")
  @EqualsAndHashCode.Exclude private Set<Patient> patients = new HashSet<>();
  
  @OneToMany(mappedBy = "hospital")
  @EqualsAndHashCode.Exclude private Set<Appointment> appointments = new HashSet<>();

  public Hospital() {
  }

  public Hospital(String name, LocalDateTime createdOn, User createdBy) {
    this.name = name;
    this.createdOn = createdOn;
    this.createdBy = createdBy;
  }
}
