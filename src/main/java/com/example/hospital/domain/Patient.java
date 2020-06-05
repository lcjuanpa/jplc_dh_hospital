package com.example.hospital.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
public class Patient {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  
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
  @JoinColumn(name = "user_id")
  @EqualsAndHashCode.Exclude private User createdBy;
  
  
  @NotNull
  @ManyToOne
  @JoinColumn(name = "hospital_id")
  @EqualsAndHashCode.Exclude private Hospital hospital;
  
  @JsonIgnore
  @OneToMany(mappedBy = "patient")
  @EqualsAndHashCode.Exclude private Set<Appointment> appointments = new HashSet<>();

  public Patient() {
  }
  
  public Patient(String name, String lastname, String address, LocalDateTime createdOn,
      User createdBy, Hospital hospital) {
    this.name = name;
    this.lastname = lastname;
    this.address = address;
    this.createdOn = createdOn;
    this.createdBy = createdBy;
    this.hospital = hospital;
  }
}
