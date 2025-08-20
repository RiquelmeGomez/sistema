package com.umg.sistema.controller;

import com.umg.sistema.dto.CursoDTO;
import com.umg.sistema.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cursos")
public class CursoController {

    @Autowired
    private CursoService service;

    @PostMapping
    public ResponseEntity<CursoDTO> create(@RequestBody CursoDTO dto) {
        return ResponseEntity.ok(service.create(dto));
    }

    @GetMapping("/{codigoCurso}")
    public ResponseEntity<CursoDTO> getById(@PathVariable String codigoCurso) {
        return ResponseEntity.ok(service.getById(codigoCurso));
    }

    // ✅ Ahora acepta filtro opcional por nombre
    @GetMapping
    public ResponseEntity<List<CursoDTO>> getAll(@RequestParam(required = false) String nombre) {
        if (nombre != null && !nombre.isEmpty()) {
            return ResponseEntity.ok(service.getByNombre(nombre));
        }
        return ResponseEntity.ok(service.getAll());
    }

    @PutMapping("/{codigoCurso}")
    public ResponseEntity<CursoDTO> update(@PathVariable String codigoCurso, @RequestBody CursoDTO dto) {
        return ResponseEntity.ok(service.update(codigoCurso, dto));
    }

    @DeleteMapping("/{codigoCurso}")
    public ResponseEntity<Void> delete(@PathVariable String codigoCurso) {
        service.delete(codigoCurso);
        return ResponseEntity.noContent().build();
    }
}
