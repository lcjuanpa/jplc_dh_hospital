package com.example.hospital;

import com.example.hospital.domain.Appointment;
import com.example.hospital.domain.Doctor;
import com.example.hospital.domain.Hospital;
import com.example.hospital.domain.Patient;
import com.example.hospital.domain.Specialty;
import com.example.hospital.domain.User;
import com.example.hospital.repository.AppointmentRepository;
import com.example.hospital.repository.DoctorRepository;
import com.example.hospital.repository.HospitalRepository;
import com.example.hospital.repository.PatientRepository;
import com.example.hospital.repository.SpecialtyRepository;
import com.example.hospital.repository.UserRepository;
import java.time.LocalDateTime;
import java.time.Month;
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
  private final DoctorRepository doctorRepository;
  private final SpecialtyRepository specialtyRepository;
  private final PatientRepository patientRepository;
  private final AppointmentRepository appointmentRepository;

  public DatabasePopulator(UserRepository userRepository, HospitalRepository hospitalRepository,
      DoctorRepository doctorRepository, SpecialtyRepository specialtyRepository,
      PatientRepository patientRepository, AppointmentRepository appointmentRepository) {
    this.userRepository = userRepository;
    this.hospitalRepository = hospitalRepository;
    this.doctorRepository = doctorRepository;
    this.specialtyRepository = specialtyRepository;
    this.patientRepository = patientRepository;
    this.appointmentRepository = appointmentRepository;
  }

  @Override
  public void run(String... args) throws Exception {
    User user1 = new User("user1", "user1pass", "administrator");
    userRepository.save(user1);
    User user2 = new User("user2", "user2pass", "administrator");
    userRepository.save(user2);
    
    Hospital hospital1 = new Hospital("Hospital No. 1", LocalDateTime.now(), user1);
    hospitalRepository.save(hospital1);
    Hospital hospital2 = new Hospital("Hospital No. 2", LocalDateTime.now(), user1);
    hospitalRepository.save(hospital2);
    
    Specialty dermatologist = new Specialty("dermatologist", LocalDateTime.now(), user1);
    specialtyRepository.save(dermatologist);
    Specialty cardiologist = new Specialty("cardiologist", LocalDateTime.now(), user1);
    specialtyRepository.save(cardiologist);
    Specialty oncologist = new Specialty("oncologist", LocalDateTime.now(), user2);
    specialtyRepository.save(oncologist);
    
    Doctor doctor1 = new Doctor("doctor uno", "lastname uno", "address 1", LocalDateTime.now(),
        user1, hospital1);
    doctor1.getSpecialties().add(dermatologist);
    doctorRepository.save(doctor1);
    
    Doctor doctor2 = new Doctor("doctor dos", "lastname dos", "address 2", LocalDateTime.now(),
        user1, hospital1);
    doctor2.getSpecialties().add(cardiologist);
    doctorRepository.save(doctor2);
    
    Doctor doctor3 = new Doctor("doctor tres", "lastname tres", "address 3", LocalDateTime.now(),
        user2, hospital2);
    doctor3.getSpecialties().add(cardiologist);
    doctor3.getSpecialties().add(oncologist);
    doctorRepository.save(doctor3);
    
    Patient patient1 = new Patient("patien one", "lastaname one", "address one", LocalDateTime.now(),
        user1, hospital1);
    patientRepository.save(patient1);
    Patient patient2 = new Patient("patien two", "lastaname two", "address two", LocalDateTime.now(),
        user1, hospital1);
    patientRepository.save(patient2);
    Patient patient3 = new Patient("patien three", "lastaname three", "address three", LocalDateTime.now(),
        user2, hospital2);
    patientRepository.save(patient3);
    
    Appointment appointment1 = new Appointment("appointment description one",
        LocalDateTime.of(2020, Month.JUNE, 15, 8, 0), hospital1,
        patient1, doctor1, LocalDateTime.now(), user1);
    appointmentRepository.save(appointment1);
    Appointment appointment2 = new Appointment("appointment description two",
        LocalDateTime.of(2020, Month.JUNE, 15, 9, 0), hospital1,
        patient2, doctor1, LocalDateTime.now(), user1);
    appointmentRepository.save(appointment2);
    Appointment appointment3 = new Appointment("appointment description two",
        LocalDateTime.of(2020, Month.JUNE, 16, 14, 30), hospital2,
        patient3, doctor2, LocalDateTime.now(), user1);
    appointmentRepository.save(appointment3);
  }
  
}
