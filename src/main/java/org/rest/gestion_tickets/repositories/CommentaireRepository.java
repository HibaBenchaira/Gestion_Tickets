package org.rest.gestion_tickets.repositories;

import org.rest.gestion_tickets.entities.Commentaire;
import org.rest.gestion_tickets.entities.Ticket;
import org.rest.gestion_tickets.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(path = "commentaires")
public interface CommentaireRepository extends JpaRepository<Commentaire, Long> {

    @Query("select commentaire from Commentaire commentaire where commentaire.ticket.id = :ticketId")
    List<Commentaire> findByTicketId(@Param("ticketId") Long ticketId);

    @Query("select commentaire from Commentaire commentaire where commentaire.user.id = :userId")
    List<Commentaire> findByUserId(@Param("userId") Long userId);

    @Query("select commentaire from Commentaire commentaire where commentaire.contenu like %:contenu%")
    List<Commentaire> findByContenuContaining(@Param("contenu") String contenu);

    @Query("select commentaire from Commentaire commentaire order by commentaire.id desc")
    List<Commentaire> findAllCommentairesSortedByIdDesc();

    @Query("select commentaire from Commentaire commentaire where commentaire.ticket = :ticket and commentaire.user = :user")
    List<Commentaire> findByTicketAndUser(@Param("ticket") Ticket ticket, @Param("user") User user);
}
