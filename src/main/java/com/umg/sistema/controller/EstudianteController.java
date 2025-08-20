package com.umg.sistema.controller;

import com.umg.sistema.dto.EstudianteDTO;
import com.umg.sistema.dto.EstudianteInputDTO;
import com.umg.sistema.service.EstudianteService;
import com.umg.sistema.entities.Estudiante;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/estudiantes")
public class EstudianteController {

    private final EstudianteService service;

    public EstudianteController(EstudianteService service) {
        this.service = service;
    }

    @GetMapping
    public List<EstudianteDTO> getAll(
            @RequestParam(required = false) String nombre,
            @RequestParam(required = false) String apellido) {

        if (nombre != null && !nombre.isEmpty()) {
            return service.filterByNombre(nombre);
        } else if (apellido != null && !apellido.isEmpty()) {
            return service.filterByApellido(apellido);
        }
        return service.getAll();
    }

    @GetMapping("/{carnet}")
    public EstudianteDTO getById(@PathVariable String carnet) {
        return service.getById(carnet);
    }

    @PostMapping
    public EstudianteDTO create(@RequestBody EstudianteInputDTO dto) {
    return service.create(dto);
    }

    @PutMapping("/{carnet}")
    public EstudianteDTO update(@PathVariable String carnet, @RequestBody EstudianteInputDTO dto) {
    return service.update(carnet, dto);
    }

    @DeleteMapping("/{carnet}")
    public void delete(@PathVariable String carnet) {
        service.delete(carnet);
    }
}
