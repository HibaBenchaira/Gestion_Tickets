package org.rest.gestion_tickets.dto;

import lombok.Data;

@Data
public class LoginRequest {
    private String email;
    private String password;
}