package com.assoulaimani.rdvservice.repository;

import com.assoulaimani.rdvservice.entity.Rdv;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface RdvRepository extends JpaRepository<Rdv, Long> {
    // Trouver tous les rdv d'un patient
    List<Rdv> findByIdPatient(Long idPatient);

    // Trouver tous les rdv d'un docteur
    List<Rdv> findByIdDocteur(Long idDocteur);

    List<Rdv> findByDateRdv(LocalDate date);

}
