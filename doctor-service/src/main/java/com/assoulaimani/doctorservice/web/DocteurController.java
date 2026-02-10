package com.assoulaimani.doctorservice.web;

import com.assoulaimani.doctorservice.entity.Docteur;
import com.assoulaimani.doctorservice.repository.DocteurRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DocteurController {
    DocteurRepository docteurRepository;
    public DocteurController(DocteurRepository docteurRepository) {
        this.docteurRepository=docteurRepository;
    }

    @GetMapping("/docteurs")
    public List<Docteur> getAllDocteurs(){
        return docteurRepository.findAll();
    }

    @GetMapping("/docteurs/{id}")
    public Docteur getDocteurById(@PathVariable Long id){
        return docteurRepository.findById(id).get();
    }

    @PostMapping("/docteurs")
    public Docteur addDocteur(@RequestBody Docteur docteur){
        return docteurRepository.save(docteur);
    }

    @PutMapping("/docteurs/{id}")
    public Docteur updateDocteur(@PathVariable Long id, @RequestBody Docteur docteur){
        docteur.setIdDocteur(id);
        return docteurRepository.save(docteur);
    }

    @DeleteMapping("/docteurs/{id}")
    public void deleteDocteur(@PathVariable Long id){
        docteurRepository.deleteById(id);
    }
}
