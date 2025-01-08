package org.rest.gestion_tickets.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "tickets")
@AllArgsConstructor
@NoArgsConstructor
public class Ticket {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String sujet;
        private String description;

        @Temporal(TemporalType.TIMESTAMP)
        private Date dateCreation;

        @Temporal(TemporalType.TIMESTAMP)
        private Date dateMiseAJour;

        @Enumerated(EnumType.STRING)
        private TicketStatus status;

        @ManyToOne
        @JoinColumn(name = "departement_id")
        private Departement departement;

        @ManyToOne
        @JoinColumn(name = "user_id")
        private User user;

        @OneToMany(mappedBy = "ticket")
        private List<Commentaire> commentaires;

        @OneToMany(mappedBy = "ticket")
        private List<Message> messages;

        @OneToMany(mappedBy = "ticket")
        private List<PieceJointe> piecesJointes;
}

