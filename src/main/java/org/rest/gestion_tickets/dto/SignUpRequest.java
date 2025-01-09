package org.rest.gestion_tickets.dto;

import lombok.Data;

@Data
public class SignUpRequest {
    private String nom;
    private String prenom;
    private String email;
    private String password;
    private String domaine;
    private String role;
}