package org.rest.gestion_tickets.service;

import org.rest.gestion_tickets.entities.Departement;
import org.rest.gestion_tickets.repository.DepartementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartementService {

    @Autowired
    private DepartementRepository departementRepository;

    public List<Departement> getAllDepartements() {
        return departementRepository.findAll();
    }

    public Departement getDepartementById(Long id) {
        return departementRepository.findById(id).orElse(null);
    }

    public Departement createDepartement(Departement departement) {
        return departementRepository.save(departement);
    }

    public Departement updateDepartement(Departement departement) {
        return departementRepository.save(departement);
    }

    public void deleteDepartement(Long id) {
        departementRepository.deleteById(id);
    }
}
