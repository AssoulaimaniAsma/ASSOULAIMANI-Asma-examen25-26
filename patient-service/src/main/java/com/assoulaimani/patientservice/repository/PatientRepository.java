package com.assoulaimani.patientservice.repository;

import com.assoulaimani.patientservice.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {
}
