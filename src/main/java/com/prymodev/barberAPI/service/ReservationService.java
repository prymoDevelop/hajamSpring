package com.prymodev.barberAPI.service;

import com.prymodev.barberAPI.domain.entity.Reservation;

import java.util.List;
import java.util.UUID;

public interface ReservationService {
    Reservation create(Reservation reservation);
    List<Reservation> getAll();
    List<Reservation> getByClient(Long clientId);
    List<Reservation> getByBarber(Long barberId);
    void cancel(Long reservationId);
}
