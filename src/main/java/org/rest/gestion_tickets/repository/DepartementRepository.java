package org.rest.gestion_tickets.repository;

import org.rest.gestion_tickets.entities.Departement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartementRepository extends JpaRepository<Departement, Long> {
    Departement findByNom(String nom);

}
