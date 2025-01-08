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
@Table(name = "messages")
@AllArgsConstructor
@NoArgsConstructor
public class Message {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String contenu;

        @Temporal(TemporalType.TIMESTAMP)
        private Date dateEnvoi;

        @ManyToOne
        @JoinColumn(name = "ticket_id")
        private Ticket ticket;

        @ManyToMany
        @JoinTable(
                name = "message_users",
                joinColumns = @JoinColumn(name = "message_id"),
                inverseJoinColumns = @JoinColumn(name = "user_id")
        )
        private List<User> users;
}



