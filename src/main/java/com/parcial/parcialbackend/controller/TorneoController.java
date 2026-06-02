package com.parcial.parcialbackend.controller;

import com.parcial.parcialbackend.entity.Torneo;
import com.parcial.parcialbackend.service.TorneoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/torneos")
@CrossOrigin(origins = "*")
public class TorneoController {

    private final TorneoService torneoService;

    public TorneoController(TorneoService torneoService) {
        this.torneoService = torneoService;
    }

    @GetMapping
    public List<Torneo> getAll() {
        return torneoService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Torneo> getById(@PathVariable Long id) {
        return torneoService.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Torneo create(@RequestBody Torneo torneo) {
        return torneoService.create(torneo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Torneo> update(@PathVariable Long id, @RequestBody Torneo torneo) {
        return torneoService.getById(id)
                .map(existing -> ResponseEntity.ok(torneoService.update(id, torneo)))
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        torneoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}