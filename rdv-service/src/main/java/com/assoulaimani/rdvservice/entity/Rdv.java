package com.assoulaimani.rdvservice.entity;


import com.assoulaimani.rdvservice.model.Docteur;
import com.assoulaimani.rdvservice.model.Patient;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Rdv {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRdv;
    private String motif;
    private LocalDate dateRdv;
    private Long idPatient;
    private Long idDocteur;
    @Transient
    private Patient patient;
    @Transient
    private Docteur docteur;
}
