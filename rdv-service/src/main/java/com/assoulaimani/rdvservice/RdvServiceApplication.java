package com.assoulaimani.rdvservice;

import com.assoulaimani.rdvservice.entity.Rdv;
import com.assoulaimani.rdvservice.repository.RdvRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients

public class RdvServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(RdvServiceApplication.class, args);
    }


    @Bean

    public CommandLineRunner commandLineRunner(RdvRepository rdvRepository) {
        return args -> {
            Rdv rdv1 = Rdv.builder()
                    .idPatient(Long.valueOf("1"))
                    .idDocteur(Long.valueOf("1"))
                    .dateRdv(LocalDate.of(2026, 1, 1))
                    .motif("urgent")
                    .build();
            rdvRepository.save(rdv1);

            Rdv rdv2 = Rdv.builder()
                    .idPatient(Long.valueOf("2"))
                    .idDocteur(Long.valueOf("1"))
                    .dateRdv(LocalDate.of(2026, 1, 1))
                    .motif("Urgent")
                    .build();
            rdvRepository.save(rdv2);

            Rdv rdv3 = Rdv.builder()
                    .idPatient(Long.valueOf("2"))
                    .idDocteur(Long.valueOf("2"))
                    .dateRdv(LocalDate.of(2026, 2, 1))
                    .motif("Urgent")
                    .build();
            rdvRepository.save(rdv3);
            List<Rdv> rdvs = rdvRepository.findAll();

            for (Rdv rdv : rdvs) {
                System.out.println(rdv.toString());

            }

        };

    }
}
