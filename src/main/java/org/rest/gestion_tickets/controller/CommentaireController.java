package org.rest.gestion_tickets.controller;

import org.rest.gestion_tickets.entities.Commentaire;
import org.rest.gestion_tickets.service.CommentaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/commentaires")
public class CommentaireController {

    @Autowired
    private CommentaireService commentaireService;

    @GetMapping("/ticket/{ticketId}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public List<Commentaire> getCommentairesByTicketId(@PathVariable Long ticketId) {
        return commentaireService.getCommentairesByTicketId(ticketId);
    }

    @PostMapping
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<Commentaire> createCommentaire(@RequestBody Commentaire commentaire) {
        Commentaire createdCommentaire = commentaireService.createCommentaire(commentaire);
        return ResponseEntity.ok(createdCommentaire);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN') or @commentaireService.isCommentaireOwner(#id, authentication.principal.id)")
    public ResponseEntity<Commentaire> updateCommentaire(@PathVariable Long id, @RequestBody Commentaire commentaire) {
        commentaire.setId(id);
        Commentaire updatedCommentaire = commentaireService.updateCommentaire(commentaire);
        return ResponseEntity.ok(updatedCommentaire);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN') or @commentaireService.isCommentaireOwner(#id, authentication.principal.id)")
    public ResponseEntity<?> deleteCommentaire(@PathVariable Long id) {
        commentaireService.deleteCommentaire(id);
        return ResponseEntity.ok().build();
    }
}