package com.prymodev.repository;

import com.prymodev.entity.AppUser;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<AppUser, String> {

    AppUser findByEmail(String username);
}
