package org.rest.gestion_tickets.controller;

import org.rest.gestion_tickets.entities.Commentaire;
import org.rest.gestion_tickets.service.CommentaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/commentaires")
public class CommentaireController {

    @Autowired
    private CommentaireService commentaireService;

    @GetMapping
    public List<Commentaire> getAllCommentaires() {
        return commentaireService.getAllCommentaires();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Commentaire> getCommentaireById(@PathVariable Long id) {
        return commentaireService.getCommentaireById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/ticket/{ticketId}")
    public List<Commentaire> getCommentairesByTicketId(@PathVariable Long ticketId) {
        return commentaireService.getCommentairesByTicketId(ticketId);
    }

    @GetMapping("/user/{userId}")
    public List<Commentaire> getCommentairesByUserId(@PathVariable Long userId) {
        return commentaireService.getCommentairesByUserId(userId);
    }

    @PostMapping
    public ResponseEntity<Commentaire> createCommentaire(@RequestBody Commentaire commentaire) {
        Commentaire createdCommentaire = commentaireService.createCommentaire(commentaire);
        return ResponseEntity.ok(createdCommentaire);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Commentaire> updateCommentaire(@PathVariable Long id, @RequestBody Commentaire commentaire) {
        commentaire.setId(id);
        Commentaire updatedCommentaire = commentaireService.updateCommentaire(commentaire);
        return ResponseEntity.ok(updatedCommentaire);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCommentaire(@PathVariable Long id) {
        commentaireService.deleteCommentaire(id);
        return ResponseEntity.ok().build();
    }
}

