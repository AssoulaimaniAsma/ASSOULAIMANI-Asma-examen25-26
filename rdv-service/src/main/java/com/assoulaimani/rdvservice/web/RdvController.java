package com.assoulaimani.rdvservice.web;

import com.assoulaimani.rdvservice.entity.Rdv;
import com.assoulaimani.rdvservice.model.Docteur;
import com.assoulaimani.rdvservice.model.Patient;
import com.assoulaimani.rdvservice.repository.RdvRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RdvController {
    private final DocteurFeign docteurFeign;
    private final PatientFeign patientFeign;
    private final RdvRepository rdvRepository;

    public RdvController(DocteurFeign docteurFeign,PatientFeign patientFeign,RdvRepository rdvRepository){
        this.docteurFeign = docteurFeign;
        this.patientFeign = patientFeign;
        this.rdvRepository = rdvRepository;
    }


    @GetMapping("/rdvs")
    public List<Rdv> getRdvs() {
        List<Docteur> docteurs = docteurFeign.getDoctors();
        List<Patient> patients = patientFeign.getPatients();
        List<Rdv> rdvs = rdvRepository.findAll();

        for (Rdv rdv : rdvs) {
            // Associer l'utilisateur
            for (Patient p : patients) {
                if (p.getIdPatient().equals(rdv.getIdPatient())) {
                    rdv.setPatient(p);
                    break;
                }
            }

            // Associer le livre
            for (Docteur d : docteurs) {
                if (d.getIdDocteur().equals(rdv.getIdDocteur())) {
                    rdv.setDocteur(d);
                    break;
                }
            }
        }

        return rdvs;
    }

    @GetMapping("/rdvs/{id}")
    public Rdv getRdv(@PathVariable Long id) {
        Rdv rdv = rdvRepository.findById(id).orElse(null);

        if (rdv != null) {
            Docteur docteur = docteurFeign.getDoctor(rdv.getIdDocteur());
            Patient patient = patientFeign.getPatient(rdv.getIdPatient());

            rdv.setDocteur(docteur);
            rdv.setPatient(patient);
        }

        return rdv;
    }

    @DeleteMapping("/rdvs/{id}")
    public void deleteRdv(@PathVariable Long id) {
        rdvRepository.deleteById(id);
    }
}
