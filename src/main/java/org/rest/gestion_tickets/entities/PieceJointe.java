package org.rest.gestion_tickets.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "pieces_jointes")
@AllArgsConstructor
@NoArgsConstructor
public class PieceJointe {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String nomFichier;
        private String chemin;

        @ManyToOne
        @JoinColumn(name = "ticket_id")
        private Ticket ticket;
}


