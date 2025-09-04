package com.umg.sistema.controller;

import com.umg.sistema.dto.CursoAsignarseDTO;
import com.umg.sistema.service.CursoAsignarseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/curso-asignarse")
public class CursoAsignarseController {

    @Autowired
    private CursoAsignarseService service;

    @PostMapping
    public ResponseEntity<CursoAsignarseDTO> create(@RequestBody CursoAsignarseDTO dto) {
        return ResponseEntity.ok(service.create(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CursoAsignarseDTO> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<CursoAsignarseDTO>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<CursoAsignarseDTO> update(@PathVariable Integer id, @RequestBody CursoAsignarseDTO dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
