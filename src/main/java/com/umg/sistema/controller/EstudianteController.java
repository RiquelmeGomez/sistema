package com.umg.sistema.controller;

import com.umg.sistema.dto.EstudianteDTO;
import com.umg.sistema.service.EstudianteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/estudiantes")
public class EstudianteController {

    @Autowired
    private EstudianteService service;

    @PostMapping
    public ResponseEntity<EstudianteDTO> create(@RequestBody EstudianteDTO dto) {
        return ResponseEntity.ok(service.create(dto));
    }

    @GetMapping("/{carnet}")
    public ResponseEntity<EstudianteDTO> getById(@PathVariable String carnet) {
        return ResponseEntity.ok(service.getById(carnet));
    }

    @GetMapping
    public ResponseEntity<List<EstudianteDTO>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @PutMapping("/{carnet}")
    public ResponseEntity<EstudianteDTO> update(@PathVariable String carnet, @RequestBody EstudianteDTO dto) {
        return ResponseEntity.ok(service.update(carnet, dto));
    }

    @DeleteMapping("/{carnet}")
    public ResponseEntity<Void> delete(@PathVariable String carnet) {
        service.delete(carnet);
        return ResponseEntity.noContent().build();
    }
}
