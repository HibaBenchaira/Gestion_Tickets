package org.rest.gestion_tickets.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Date;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tickets")
public class Ticket {
        @Id
        @GeneratedValue(strategy = 
                GenerationType.IDENTITY)
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

        @ManyToMany
        @JoinTable(
                name = "ticket_messages",
                joinColumns = @JoinColumn(name = "ticket_id"),
                inverseJoinColumns = @JoinColumn(name = "message_id")
        )
        private List<Message> messages;

        @OneToMany(mappedBy = "ticket", cascade = CascadeType.ALL)
        private List<Commentaire> commentaires;



        @OneToMany(mappedBy = "ticket", cascade = CascadeType.ALL)
        private List<PieceJointe> piecesJointes;
    }

