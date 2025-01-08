package org.rest.gestion_tickets.service;

import org.rest.gestion_tickets.entities.Commentaire;
import org.rest.gestion_tickets.repository.CommentaireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CommentaireService {

    @Autowired
    private CommentaireRepository commentaireRepository;

    public List<Commentaire> getAllCommentaires() {
        return commentaireRepository.findAll();
    }

    public Optional<Commentaire> getCommentaireById(Long id) {
        return commentaireRepository.findById(id);
    }

    public List<Commentaire> getCommentairesByTicketId(Long ticketId) {
        return commentaireRepository.findByTicketId(ticketId);
    }

    public List<Commentaire> getCommentairesByUserId(Long userId) {
        return commentaireRepository.findByUserId(userId);
    }

    public Commentaire createCommentaire(Commentaire commentaire) {
        return commentaireRepository.save(commentaire);
    }

    public Commentaire updateCommentaire(Commentaire commentaire) {
        return commentaireRepository.save(commentaire);
    }

    public void deleteCommentaire(Long id) {
        commentaireRepository.deleteById(id);
    }
}

