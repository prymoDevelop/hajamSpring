package com.prymodev.barberAPI.domain.repository;

import com.prymodev.barberAPI.domain.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    List<Reservation> findByBarberId(Long barberId);
    List<Reservation> findByClientId(Long clientId);
}