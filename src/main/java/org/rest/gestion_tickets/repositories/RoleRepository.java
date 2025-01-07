package org.rest.gestion_tickets.repositories;

import org.rest.gestion_tickets.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(path = "roles")
public interface RoleRepository extends JpaRepository<Role, Long> {

    @Query("select r from Role r where r.role like %:roleName%")
    List<Role> findByRoleContaining(@Param("roleName") String roleName);

    @Query("select r from Role r order by r.role")
    List<Role> findAllRolesSortedByName();

}