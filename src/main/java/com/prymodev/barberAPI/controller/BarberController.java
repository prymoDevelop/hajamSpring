package com.prymodev.barberAPI.controller;

import com.prymodev.barberAPI.domain.entity.Barber;
import com.prymodev.barberAPI.service.BarberService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/barbers")
public class BarberController {

    private final BarberService barberService;

    public BarberController(BarberService barberService) {
        this.barberService = barberService;
    }

    @GetMapping
    public List<Barber> getBarbers() {
        return barberService.getBarbers();
    }
}