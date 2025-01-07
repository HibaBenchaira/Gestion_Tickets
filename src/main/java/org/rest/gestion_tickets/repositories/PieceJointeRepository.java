package org.rest.gestion_tickets.repositories;

import org.rest.gestion_tickets.entities.PieceJointe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(path = "pieces_jointes")
public interface PieceJointeRepository extends JpaRepository<PieceJointe, Long> {

    @Query("select pj from PieceJointe pj where pj.nomFichier like %:nomFichier%")
    List<PieceJointe> findByNomFichierContaining(@Param("nomFichier") String nomFichier);

    @Query("select pj from PieceJointe pj where pj.chemin like %:chemin%")
    List<PieceJointe> findByCheminContaining(@Param("chemin") String chemin);

    @Query("select pj from PieceJointe pj where pj.ticket.id = :ticketId")
    List<PieceJointe> findByTicketId(@Param("ticketId") Long ticketId);

    @Query("select pj from PieceJointe pj order by pj.nomFichier")
    List<PieceJointe> findAllPiecesJointesSortedByName();

}
