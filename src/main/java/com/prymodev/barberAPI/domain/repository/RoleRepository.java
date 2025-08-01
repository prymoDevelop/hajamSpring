package com.prymodev.barberAPI.domain.repository;

import com.prymodev.barberAPI.domain.entity.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<AppRole, Long> {
     AppRole findByRoleName(String role);
}
