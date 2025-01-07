package org.rest.gestion_tickets.repository;

import org.rest.gestion_tickets.entities.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {
    List<Message> findByTicketId(Long ticketId);
    List<Message> findByUsersId(Long userId);
}
