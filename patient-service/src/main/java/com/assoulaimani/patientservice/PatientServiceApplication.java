package com.assoulaimani.patientservice;

import com.assoulaimani.patientservice.entity.Patient;
import com.assoulaimani.patientservice.repository.PatientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
@EnableDiscoveryClient
public class PatientServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(PatientServiceApplication.class, args);
    }
    @Bean
    CommandLineRunner init(PatientRepository patientRepository) {
        return args -> {
            Patient p1= Patient.builder()
                    .nom("Assoulaimani")
                    .prenom("Asma")
                    .telephone("0612345678")
                    .build();

            patientRepository.save(p1);

            Patient p2=Patient.builder()
                    .nom("Elimari")
                    .prenom("Latifa")
                    .telephone("0627584O85")
                    .build();
            patientRepository.save(p2);

            Patient p3=Patient.builder()
                    .nom("Majdoule")
                    .prenom("Manal")
                    .telephone("06838798787")
                    .build();
            patientRepository.save(p3);

            List<Patient> liste=patientRepository.findAll();

            for ( Patient l : liste ) {
                System.out.println(l.getNom());
                System.out.println(l.getPrenom());
                System.out.println(l.getTelephone());
            }


        };
    }
}
