package com.assoulaimani.rdvservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Docteur {

    private Long idDocteur;
    private String nom;
    private String prenom;
    private String email;
    private String specialite;
}
