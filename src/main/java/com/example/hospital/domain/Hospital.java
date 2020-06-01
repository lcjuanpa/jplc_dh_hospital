package com.example.hospital.domain;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Data;

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
  private User createdBy;

  public Hospital() {
  }

  public Hospital(String name, LocalDateTime createdOn, User createdBy) {
    this.name = name;
    this.createdOn = createdOn;
    this.createdBy = createdBy;
  }
}
