package com.assoulaimani.rdvservice.web;

import com.assoulaimani.rdvservice.model.Docteur;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name="DOCTOR-SERVICE")

public interface DocteurFeign {
    @GetMapping("/api/docteurs")
    List<Docteur> getDoctors();

    @GetMapping("/api/docteurs/{id}")
    Docteur getDoctor(@PathVariable Long id);
}
