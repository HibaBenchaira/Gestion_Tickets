package org.rest.gestion_tickets.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@Table(name = "departements")
@AllArgsConstructor
@NoArgsConstructor
public class Departement {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String nom;

        @OneToMany(mappedBy = "departement")
        private List<Ticket> tickets;
}


