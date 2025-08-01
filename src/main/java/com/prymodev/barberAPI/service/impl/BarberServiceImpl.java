package com.prymodev.barberAPI.service.impl;

import com.prymodev.barberAPI.domain.entity.Barber;
import com.prymodev.barberAPI.domain.repository.BarberRepository;
import com.prymodev.barberAPI.service.BarberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BarberServiceImpl implements BarberService {
    private final BarberRepository barberRepository;

    public List<Barber> getBarbers() {
        return barberRepository.findAll();
    }
}
