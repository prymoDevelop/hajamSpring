package com.prymodev.barberAPI.service.impl;

import com.prymodev.barberAPI.domain.entity.Reservation;
import com.prymodev.barberAPI.domain.repository.ReservationRepository;
import com.prymodev.barberAPI.service.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReservationServiceImpl implements ReservationService {

    private final ReservationRepository reservationRepository;

    @Override
    public Reservation create(Reservation reservation) {
        reservation.setStatus("PENDING");
        return reservationRepository.save(reservation);
    }

    @Override
    public List<Reservation> getAll() {
        return reservationRepository.findAll();
    }

    @Override
    public List<Reservation> getByClient(Long clientId) {
        return reservationRepository.findByClientId(clientId);
    }

    @Override
    public List<Reservation> getByBarber(Long barberId) {
        return reservationRepository.findByBarberId(barberId);
    }

    @Override
    public void cancel(Long reservationId) {
        reservationRepository.deleteById(reservationId);
    }
}