package org.rest.gestion_tickets.controller;

import org.rest.gestion_tickets.entities.PieceJointe;
import org.rest.gestion_tickets.service.PieceJointeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/piecejointes")
public class PieceJointeController {

    @Autowired
    private PieceJointeService pieceJointeService;

    @GetMapping
    public List<PieceJointe> getAllPieceJointes() {
        return pieceJointeService.getAllPieceJointes();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PieceJointe> getPieceJointeById(@PathVariable Long id) {
        PieceJointe pieceJointe = pieceJointeService.getPieceJointeById(id);
        return pieceJointe != null ? ResponseEntity.ok(pieceJointe) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public PieceJointe createPieceJointe(@RequestBody PieceJointe pieceJointe) {
        return pieceJointeService.createPieceJointe(pieceJointe);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PieceJointe> updatePieceJointe(@PathVariable Long id, @RequestBody PieceJointe pieceJointe) {
        pieceJointe.setId(id);
        PieceJointe updatedPieceJointe = pieceJointeService.updatePieceJointe(pieceJointe);
        return updatedPieceJointe != null ? ResponseEntity.ok(updatedPieceJointe) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePieceJointe(@PathVariable Long id) {
        pieceJointeService.deletePieceJointe(id);
        return ResponseEntity.ok().build();
    }
}

