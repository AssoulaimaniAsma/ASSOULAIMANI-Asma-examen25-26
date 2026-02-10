package com.assoulaimani.rdvservice.web;

import com.assoulaimani.rdvservice.model.Patient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name="PATIENT-SERVICE")
public interface PatientFeign {
    @GetMapping("/api/patients")
    List<Patient> getPatients();

    @GetMapping("/api/patients/{id}")
    Patient getPatient(@PathVariable Long id);
}
