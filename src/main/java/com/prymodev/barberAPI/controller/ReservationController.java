package com.prymodev.barberAPI.controller;

import com.prymodev.barberAPI.domain.entity.Reservation;
import com.prymodev.barberAPI.service.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/reservations")
@RequiredArgsConstructor
public class ReservationController {

    private final ReservationService reservationService;

    @PostMapping
    public ResponseEntity<Reservation> create(@RequestBody Reservation reservation) {
        return ResponseEntity.ok(reservationService.create(reservation));
    }

    @GetMapping
    public List<Reservation> getAll() {
        return reservationService.getAll();
    }

    @GetMapping("/client/{id}")
    public List<Reservation> getByClient(@PathVariable Long id) {
        return reservationService.getByClient(id);
    }

    @GetMapping("/barber/{id}")
    public List<Reservation> getByBarber(@PathVariable Long id) {
        return reservationService.getByBarber(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> cancel(@PathVariable Long id) {
        reservationService.cancel(id);
        return ResponseEntity.ok().build();
    }
}