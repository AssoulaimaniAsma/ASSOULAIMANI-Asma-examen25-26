package com.assoulaimani.doctorservice.repository;

import com.assoulaimani.doctorservice.entity.Docteur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocteurRepository extends JpaRepository<Docteur, Long> {
}

