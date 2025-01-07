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
@Table(name = "messages")
public class Message {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String contenu;

        @Temporal(TemporalType.TIMESTAMP)
        private Date dateEnvoi;

        @ManyToMany(mappedBy = "messages")
        private List<Ticket> tickets;

        @ManyToMany(mappedBy = "messages")
        private List<User> users;
    }

