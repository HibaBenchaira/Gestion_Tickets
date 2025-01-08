package org.rest.gestion_tickets.repository;

import org.rest.gestion_tickets.entities.Commentaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentaireRepository extends JpaRepository<Commentaire, Long> {
    List<Commentaire> findByTicketId(Long ticketId);
    List<Commentaire> findByUserId(Long userId);

}

