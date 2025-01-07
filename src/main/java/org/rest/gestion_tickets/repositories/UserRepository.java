package org.rest.gestion_tickets.repositories;

import org.rest.gestion_tickets.entities.User;
import org.rest.gestion_tickets.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(path = "users")
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("select user from User user where user.email = :email")
    User findByEmail(@Param("email") String email);

    @Query("select user from User user where user.nom like %:nom%")
    List<User> findByNomContaining(@Param("nom") String nom);

    @Query("select user from User user where user.role = :role")
    List<User> findByRole(@Param("role") Role role);

    @Query("select user from User user where user.domaine like %:domaine%")
    List<User> findByDomaineContaining(@Param("domaine") String domaine);

    @Query("select user from User user order by user.nom, user.prenom")
    List<User> findAllUsersSortedByName();

    @Query("select user from User user where size(user.tickets) > :minTickets")
    List<User> findByMinTickets(@Param("minTickets") int minTickets);

    @Query("select user from User user where size(user.commentaires) > :minCommentaires")
    List<User> findByMinCommentaires(@Param("minCommentaires") int minCommentaires);
}
