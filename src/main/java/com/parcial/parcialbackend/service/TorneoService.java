package com.parcial.parcialbackend.service;

import com.parcial.parcialbackend.entity.Torneo;
import com.parcial.parcialbackend.repository.TorneoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TorneoService {

    private final TorneoRepository torneoRepository;

    public TorneoService(TorneoRepository torneoRepository) {
        this.torneoRepository = torneoRepository;
    }

    public List<Torneo> getAll() {
        return torneoRepository.findAll();
    }

    public Optional<Torneo> getById(Long id) {
        return torneoRepository.findById(id);
    }

    public Torneo create(Torneo torneo) {
        return torneoRepository.save(torneo);
    }

    public Torneo update(Long id, Torneo torneo) {
        Torneo existing = torneoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Torneo no encontrado"));
        existing.setNombre(torneo.getNombre());
        existing.setDeporte(torneo.getDeporte());
        existing.setFechaInicio(torneo.getFechaInicio());
        existing.setCiudad(torneo.getCiudad());
        return torneoRepository.save(existing);
    }

    public void delete(Long id) {
        torneoRepository.deleteById(id);
    }
}