package org.rest.gestion_tickets.repositories;

import org.rest.gestion_tickets.entities.Departement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(path = "departements")
public interface DepartementRepository extends JpaRepository<Departement, Long> {

    @Query("select departement from Departement departement where departement.nom like %:nom%")
    List<Departement> findByNomContaining(@Param("nom") String nom);

    @Query("select departement from Departement departement order by departement.nom")
    List<Departement> findAllDepartementsSortedByName();

    @Query("select departement from Departement departement where size(departement.tickets) > :minTickets")
    List<Departement> findByMinTickets(@Param("minTickets") int minTickets);

}
