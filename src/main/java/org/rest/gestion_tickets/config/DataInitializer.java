package org.rest.gestion_tickets.config;

import org.rest.gestion_tickets.entities.Departement;
import org.rest.gestion_tickets.entities.PieceJointe;
import org.rest.gestion_tickets.entities.Role;
import org.springframework.boot.CommandLineRunner;

import java.util.Arrays;
import java.util.List;

public class DataInitializer implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {

        List<Role> roles = Arrays.asList(
                Role.builder().role("Admin").build(),
                Role.builder()
                        .role("User")
                        .build()
        );
        List<Departement> departements= Arrays.asList(
                Departement.builder()
                        .nom("IT")
                        .build(),

                Departement.builder()
                        .nom("HR")
                        .build(),

                Departement.builder()
                        .nom("Finance")
                        .build()
        );
        List<PieceJointe> PieceJointes= Arrays.asList(
                PieceJointe.builder()
                        .nomFichier("ticket1").chemin("/Users/bench/Desktop/1.jpeg")
                        .build()
        );
    }
}
