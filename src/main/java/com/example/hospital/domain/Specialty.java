package com.example.hospital.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
public class Specialty {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  
  @NotBlank(message = "Name is mandatory")
  @Column(nullable = false, unique = true, length = 100)
  private String name;
  
  private String description;
  private String avatarUrl;
  
  @NotNull
  @Column(nullable = false)
  private LocalDateTime createdOn;
  
  @NotNull
  @ManyToOne
  @JoinColumn(name = "user_id")
  @EqualsAndHashCode.Exclude private User createdBy;
  
  @JsonIgnore
  @ManyToMany(mappedBy = "specialties")
  @EqualsAndHashCode.Exclude private Set<Doctor> doctors = new HashSet<>();

  public Specialty() {
  }

  public Specialty(String name, LocalDateTime createdOn, User createdBy) {
    this.name = name;
    this.createdOn = createdOn;
    this.createdBy = createdBy;
  }
}
