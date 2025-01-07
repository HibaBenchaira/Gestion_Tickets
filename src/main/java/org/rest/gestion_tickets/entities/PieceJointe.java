package org.rest.gestion_tickets.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "pieces_jointes")
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

