package org.rest.gestion_tickets.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "commentaires")
public class Commentaire {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String contenu;

        @ManyToOne
        @JoinColumn(name = "ticket_id")
        private Ticket ticket;

        @ManyToOne
        @JoinColumn(name = "user_id")
        private User user;

}

