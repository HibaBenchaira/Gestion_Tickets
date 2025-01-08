package org.rest.gestion_tickets.controller;

import org.rest.gestion_tickets.entities.Message;
import org.rest.gestion_tickets.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/messages")
public class MessageController {

    @Autowired
    private MessageService messageService;

    @GetMapping
    public List<Message> getAllMessages() {
        return messageService.getAllMessages();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Message> getMessageById(@PathVariable Long id) {
        return messageService.getMessageById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/ticket/{ticketId}")
    public List<Message> getMessagesByTicketId(@PathVariable Long ticketId) {
        return messageService.getMessagesByTicketId(ticketId);
    }

    @GetMapping("/user/{userId}")
    public List<Message> getMessagesByUserId(@PathVariable Long userId) {
        return messageService.getMessagesByUserId(userId);
    }

    @PostMapping
    public ResponseEntity<Message> createMessage(@RequestBody Message message) {
        Message createdMessage = messageService.createMessage(message);
        return ResponseEntity.ok(createdMessage);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Message> updateMessage(@PathVariable Long id, @RequestBody Message message) {
        message.setId(id);
        Message updatedMessage = messageService.updateMessage(message);
        return ResponseEntity.ok(updatedMessage);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMessage(@PathVariable Long id) {
        messageService.deleteMessage(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/{messageId}/addUser/{userId}")
    public ResponseEntity<Message> addUserToMessage(@PathVariable Long messageId, @PathVariable Long userId) {
        Message updatedMessage = messageService.addUserToMessage(messageId, userId);
        return ResponseEntity.ok(updatedMessage);
    }
}


