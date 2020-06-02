package com.example.hospital.domain;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
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
public class Doctor {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long ig;
  
  @NotBlank(message = "Name is mandatory")
  @Column(nullable = false, length = 20)
  private String name;
  
  @NotBlank(message = "Lastname is mandatory")
  @Column(nullable = false, length = 20)
  private String lastname;
  
  private LocalDateTime birthday;
  
  @NotBlank(message = "Address is mandatory")
  @Column(nullable = false, length = 300)
  private String address;
  
  private String photoUrl;
  
  @NotNull
  @Column(nullable = false)
  private LocalDateTime createdOn;
  
  @NotNull
  @ManyToOne
  @EqualsAndHashCode.Exclude private User createdBy;
  
  @NotNull
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "hospital_id")
  @EqualsAndHashCode.Exclude private Hospital hospital;
  
  @ManyToMany
  @JoinTable(name = "doctor_specialty",
      joinColumns = { @JoinColumn(name = "doctor_id") },
      inverseJoinColumns = { @JoinColumn(name = "specialty_id")} )
  @EqualsAndHashCode.Exclude private Set<Specialty> specialties = new HashSet<>();

  public Doctor() {
  }

  public Doctor(String name, String lastname, String address, LocalDateTime createdOn,
      User createdBy, Hospital hospital) {
    this.name = name;
    this.lastname = lastname;
    this.address = address;
    this.createdOn = createdOn;
    this.createdBy = createdBy;
    this.hospital = hospital;
  }
}
