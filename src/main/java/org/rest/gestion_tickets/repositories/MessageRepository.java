package org.rest.gestion_tickets.repositories;

import org.rest.gestion_tickets.entities.Message;
import org.rest.gestion_tickets.entities.Ticket;
import org.rest.gestion_tickets.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Date;
import java.util.List;

@RepositoryRestResource(path = "messages")
public interface MessageRepository extends JpaRepository<Message, Long> {

    @Query("select message from Message message where message.contenu like %:contenu%")
    List<Message> findByContenuContaining(@Param("contenu") String contenu);

    @Query("select message from Message message where message.dateEnvoi between :startDate and :endDate")
    List<Message> findByDateEnvoiBetween(@Param("startDate") Date startDate, @Param("endDate") Date endDate);

    @Query("select message from Message message join message.tickets ticket where ticket.id = :ticketId")
    List<Message> findByTicketId(@Param("ticketId") Long ticketId);

    @Query("select message from Message message join message.users user where user.id = :userId")
    List<Message> findByUserId(@Param("userId") Long userId);

    @Query("select message from Message message order by message.dateEnvoi desc")
    List<Message> findAllMessagesSortedByDateDesc();

    @Query("select message from Message message where size(message.tickets) > :minTickets")
    List<Message> findByMinTickets(@Param("minTickets") int minTickets);
}
