package com.example.hospital.domain;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
public class Appointment {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  
  @NotBlank(message = "Description is mandatory")
  @Column(nullable = false, length = 300)
  private String description;
  
  @NotNull(message = "Date Time is mandatory")
  private LocalDateTime dateTime;
  
  @NotNull(message = "Hospital is mandatory")
  @ManyToOne
  @JoinColumn(name = "hospital_id")
  @EqualsAndHashCode.Exclude private Hospital hospital;
  
  @NotNull(message = "Patient is mandatory")
  @ManyToOne
  @JoinColumn(name = "patient_id")
  @EqualsAndHashCode.Exclude private Patient patient;
  
  @NotNull(message = "Doctor is mandatory")
  @ManyToOne
  @JoinColumn(name = "doctor_id")
  @EqualsAndHashCode.Exclude private Doctor doctor;
  
  @NotNull
  private LocalDateTime createdOn;
  
  @NotNull
  @ManyToOne
  @JoinColumn(name = "user_id")
  @EqualsAndHashCode.Exclude private User createdBy;

  public Appointment() {
  }

  public Appointment(String description, LocalDateTime dateTime, Hospital hospital,
      Patient patient, Doctor doctor, LocalDateTime createdOn, User createdBy) {
    this.description = description;
    this.dateTime = dateTime;
    this.hospital = hospital;
    this.patient = patient;
    this.doctor = doctor;
    this.createdOn = createdOn;
    this.createdBy = createdBy;
  }
  
}
