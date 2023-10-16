package com.devsuperior.desafio.repositories;

import com.devsuperior.desafio.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
