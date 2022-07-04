package com.prymodev.repository;

import com.prymodev.entity.AppRole;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends MongoRepository<AppRole, String> {
    public AppRole findByRoleName(String role);
}
