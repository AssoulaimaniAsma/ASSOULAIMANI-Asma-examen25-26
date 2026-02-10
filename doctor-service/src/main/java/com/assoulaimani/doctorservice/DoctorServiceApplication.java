package com.assoulaimani.doctorservice;

import com.assoulaimani.doctorservice.entity.Docteur;
import com.assoulaimani.doctorservice.repository.DocteurRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
@EnableDiscoveryClient
public class DoctorServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(DoctorServiceApplication.class, args);
    }
    @Bean
    CommandLineRunner init(DocteurRepository docteurRepository) {
        return args -> {
            Docteur d1= Docteur.builder()
                    .nom("M.Janati")
                    .prenom("Ahmed")
                    .email("Ahmed@gmail.com")
                    .specialite("Cardio")
                    .build();

            docteurRepository.save(d1);

            Docteur d2=Docteur.builder()
                    .nom("M.Abid")
                    .prenom("Mohamed")
                    .email("MoHamed@gmail.com")
                    .specialite("ortho")
                    .build();
            docteurRepository.save(d2);

            Docteur d3=Docteur.builder()
                    .nom("M.Idmoussa")
                    .prenom("Ayoub")
                    .email("Ayoub@gmail.com")
                    .specialite("generaliste")
                    .build();
            docteurRepository.save(d3);

            List<Docteur> liste=docteurRepository.findAll();

            for ( Docteur l : liste ) {
                System.out.println(l.getNom());
                System.out.println(l.getPrenom());
                System.out.println(l.getSpecialite());
            }


        };
    }
}
