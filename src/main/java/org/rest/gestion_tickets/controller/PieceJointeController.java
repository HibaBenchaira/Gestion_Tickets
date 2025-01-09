package org.rest.gestion_tickets.controller;

import org.rest.gestion_tickets.entities.PieceJointe;
import org.rest.gestion_tickets.service.PieceJointeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pieces-jointes")
public class PieceJointeController {

    @Autowired
    private PieceJointeService pieceJointeService;

    @GetMapping("/ticket/{ticketId}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public List<PieceJointe> getPieceJointesByTicketId(@PathVariable Long ticketId) {
        return pieceJointeService.getPieceJointesByTicketId(ticketId);
    }

    @PostMapping
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<PieceJointe> createPieceJointe(@RequestBody PieceJointe pieceJointe) {
        PieceJointe createdPieceJointe = pieceJointeService.createPieceJointe(pieceJointe);
        return ResponseEntity.ok(createdPieceJointe);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN') or @pieceJointeService.isPieceJointeOwner(#id, authentication.principal.id)")
    public ResponseEntity<?> deletePieceJointe(@PathVariable Long id) {
        pieceJointeService.deletePieceJointe(id);
        return ResponseEntity.ok().build();
    }
}