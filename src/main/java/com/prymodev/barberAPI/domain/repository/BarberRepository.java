package com.prymodev.barberAPI.domain.repository;

import com.prymodev.barberAPI.domain.entity.Barber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BarberRepository extends JpaRepository<Barber, Long> {

}