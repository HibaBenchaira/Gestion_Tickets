package org.rest.gestion_tickets.repository;

import org.rest.gestion_tickets.entities.Ticket;
import org.rest.gestion_tickets.entities.TicketStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {
    List<Ticket> findByStatus(TicketStatus status);
    List<Ticket> findByUserId(Long userId);
    List<Ticket> findByDepartementId(Long departementId);
    List<Ticket> findByStatusAndDepartementId(TicketStatus status, Long departementId);

}

