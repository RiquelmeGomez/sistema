package com.umg.sistema.controller;

import com.umg.sistema.dto.ProfesorDTO;
import com.umg.sistema.service.ProfesorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/profesores")
public class ProfesorController {

    @Autowired
    private ProfesorService service;

    @PostMapping
    public ResponseEntity<ProfesorDTO> create(@RequestBody ProfesorDTO dto) {
        return ResponseEntity.ok(service.create(dto));
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<ProfesorDTO> getById(@PathVariable String codigo) {
        return ResponseEntity.ok(service.getById(codigo));
    }

    // GET principal con filtro 
    @GetMapping
    public ResponseEntity<List<ProfesorDTO>> getAll(@RequestParam(required = false) String nombre) {
        if (nombre != null && !nombre.isEmpty()) {
            return ResponseEntity.ok(service.getByNombre(nombre));
        }
        return ResponseEntity.ok(service.getAll());
    }

    @PutMapping("/{codigo}")
    public ResponseEntity<ProfesorDTO> update(@PathVariable String codigo, @RequestBody ProfesorDTO dto) {
        return ResponseEntity.ok(service.update(codigo, dto));
    }

    @DeleteMapping("/{codigo}")
    public ResponseEntity<Void> delete(@PathVariable String codigo) {
        service.delete(codigo);
        return ResponseEntity.noContent().build();
    }
}
