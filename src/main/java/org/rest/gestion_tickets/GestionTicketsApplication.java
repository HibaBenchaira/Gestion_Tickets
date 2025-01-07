package org.rest.gestion_tickets;

import org.rest.gestion_tickets.entities.Departement;
import org.rest.gestion_tickets.entities.PieceJointe;
import org.rest.gestion_tickets.entities.Role;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class GestionTicketsApplication {

    public static void main(String[] args) {
        SpringApplication.run(GestionTicketsApplication.class, args);

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
