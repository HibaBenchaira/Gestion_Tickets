package org.rest.gestion_tickets.controller;
import java.util.Optional;
import org.rest.gestion_tickets.entities.Departement;
import org.rest.gestion_tickets.service.DepartementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/departements")
public class DepartementController {

    @Autowired
    private DepartementService departementService;

    @GetMapping
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public List<Departement> getAllDepartements() {
        return departementService.getAllDepartements();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<Departement> getDepartementById(@PathVariable Long id) {
        return departementService.getDepartementById(id)
                .map(departement -> ResponseEntity.ok(departement))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Departement> createDepartement(@RequestBody Departement departement) {
        Departement createdDepartement = departementService.createDepartement(departement);
        return ResponseEntity.ok(createdDepartement);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Departement> updateDepartement(@PathVariable Long id, @RequestBody Departement departement) {
        departement.setId(id);
        Departement updatedDepartement = departementService.updateDepartement(departement);
        return ResponseEntity.ok(updatedDepartement);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> deleteDepartement(@PathVariable Long id) {
        departementService.deleteDepartement(id);
        return ResponseEntity.ok().build();
    }
}