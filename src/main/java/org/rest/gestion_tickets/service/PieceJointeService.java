package org.rest.gestion_tickets.service;


import org.rest.gestion_tickets.entities.PieceJointe;
import org.rest.gestion_tickets.repository.PieceJointeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PieceJointeService {

    @Autowired
    private PieceJointeRepository pieceJointeRepository;

    public List<PieceJointe> getAllPieceJointes() {
        return pieceJointeRepository.findAll();
    }

    public PieceJointe getPieceJointeById(Long id) {
        return pieceJointeRepository.findById(id).orElse(null);
    }

    public PieceJointe createPieceJointe(PieceJointe pieceJointe) {
        return pieceJointeRepository.save(pieceJointe);
    }

    public PieceJointe updatePieceJointe(PieceJointe pieceJointe) {
        return pieceJointeRepository.save(pieceJointe);
    }

    public void deletePieceJointe(Long id) {
        pieceJointeRepository.deleteById(id);
    }
}


