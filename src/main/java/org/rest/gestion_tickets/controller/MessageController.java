package org.rest.gestion_tickets.controller;

import org.rest.gestion_tickets.entities.Message;
import org.rest.gestion_tickets.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/messages")
public class MessageController {

    @Autowired
    private MessageService messageService;

    @GetMapping("/ticket/{ticketId}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public List<Message> getMessagesByTicketId(@PathVariable Long ticketId) {
        return messageService.getMessagesByTicketId(ticketId);
    }

    @PostMapping
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<Message> createMessage(@RequestBody Message message) {
        Message createdMessage = messageService.createMessage(message);
        return ResponseEntity.ok(createdMessage);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN') or @messageService.isMessageOwner(#id, authentication.principal.id)")
    public ResponseEntity<?> deleteMessage(@PathVariable Long id) {
        messageService.deleteMessage(id);
        return ResponseEntity.ok().build();
    }
}