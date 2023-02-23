package com.groupe.ecobank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class EcobankApplication {

    public static void main(String[] args) {
        SpringApplication.run(EcobankApplication.class, args);
    }

}
