package com.umg.sistema.controller;

import com.umg.sistema.dto.InscripcionDTO;
import com.umg.sistema.service.InscripcionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inscripciones")
public class InscripcionController {

    @Autowired
    private InscripcionService service;

    @PostMapping
    public ResponseEntity<InscripcionDTO> create(@RequestBody InscripcionDTO dto) {
        return ResponseEntity.ok(service.create(dto));
    }

    @GetMapping("/{idInscripcion}")
    public ResponseEntity<InscripcionDTO> getById(@PathVariable Integer idInscripcion) {
        return ResponseEntity.ok(service.getById(idInscripcion));
    }

    @GetMapping
    public ResponseEntity<List<InscripcionDTO>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @PutMapping("/{idInscripcion}")
    public ResponseEntity<InscripcionDTO> update(@PathVariable Integer idInscripcion, @RequestBody InscripcionDTO dto) {
        return ResponseEntity.ok(service.update(idInscripcion, dto));
    }

    @DeleteMapping("/{idInscripcion}")
    public ResponseEntity<Void> delete(@PathVariable Integer idInscripcion) {
        service.delete(idInscripcion);
        return ResponseEntity.noContent().build();
    }
}
