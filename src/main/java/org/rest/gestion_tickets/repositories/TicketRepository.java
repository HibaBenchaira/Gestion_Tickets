package org.rest.gestion_tickets.repositories;

import org.rest.gestion_tickets.entities.Ticket;
import org.rest.gestion_tickets.entities.Departement;
import org.rest.gestion_tickets.entities.TicketStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Date;
import java.util.List;

@RepositoryRestResource(path = "rest")
public interface TicketRepository extends JpaRepository<Ticket, Long> {

    @Query("select ticket from Ticket ticket where ticket.status = :status")
    List<Ticket> findAllTicketsByStatus(@Param("status") TicketStatus status);

    @Query("select ticket from Ticket ticket where ticket.departement = :departement")
    List<Ticket> findAllTicketsByDepartement(@Param("departement") Departement departement);

    @Query("select ticket from Ticket ticket where ticket.dateCreation >= :startDate and ticket.dateCreation <= :endDate")
    List<Ticket> findAllTicketsByDateRange(@Param("startDate") Date startDate, @Param("endDate") Date endDate);

    @Query("select ticket from Ticket ticket where ticket.user.id = :userId")
    List<Ticket> findAllTicketsByUserId(@Param("userId") Long userId);

    @Query("select ticket from Ticket ticket where ticket.sujet like %:sujet%")
    List<Ticket> findAllTicketsBySujetContaining(@Param("sujet") String sujet);

    @Query("select ticket from Ticket ticket order by ticket.dateMiseAJour desc")
    List<Ticket> findAllTicketsOrderByDateMiseAJourDesc();

    @Query("select ticket from Ticket ticket where ticket.messages.size > :minMessages")
    List<Ticket> findAllTicketsByMinMessages(@Param("minMessages") int minMessages);

    @Query("select ticket from Ticket ticket where ticket.commentaires.size > :minCommentaires")
    List<Ticket> findAllTicketsByMinCommentaires(@Param("minCommentaires") int minCommentaires);

    @Query("select ticket from Ticket ticket where ticket.piecesJointes.size > :minPiecesJointes")
    List<Ticket> findAllTicketsByMinPiecesJointes(@Param("minPiecesJointes") int minPiecesJointes);
}
