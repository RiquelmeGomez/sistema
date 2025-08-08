package com.umg.sistema.service.impl;

import com.umg.sistema.dto.EstudianteDTO;
import com.umg.sistema.entities.Estudiante;
import com.umg.sistema.repositories.EstudianteRepository;
import com.umg.sistema.service.EstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EstudianteServiceImpl implements EstudianteService {

    @Autowired
    private EstudianteRepository repository;

    @Override
    public EstudianteDTO create(EstudianteDTO dto) {
        Estudiante estudiante = toEntity(dto);
        return toDTO(repository.save(estudiante));
    }

    @Override
    public EstudianteDTO update(String carnet, EstudianteDTO dto) {
        Estudiante existente = repository.findById(carnet)
            .orElseThrow(() -> new RuntimeException("Estudiante no encontrado"));
        existente.setNombre(dto.getNombre());
        existente.setApellido(dto.getApellido());
        existente.setFechaNacimiento(dto.getFechaNacimiento());
        return toDTO(repository.save(existente));
    }

    @Override
    public void delete(String carnet) {
        repository.deleteById(carnet);
    }

    @Override
    public EstudianteDTO getById(String carnet) {
        Estudiante estudiante = repository.findById(carnet)
            .orElseThrow(() -> new RuntimeException("Estudiante no encontrado"));
        return toDTO(estudiante);
    }

    @Override
    public List<EstudianteDTO> getAll() {
        return repository.findAll()
            .stream()
            .map(this::toDTO)
            .collect(Collectors.toList());
    }

    // Métodos auxiliares para convertir entre DTO y entidad

    private EstudianteDTO toDTO(Estudiante estudiante) {
        EstudianteDTO dto = new EstudianteDTO();
        dto.setCarnet(estudiante.getCarnet());
        dto.setNombre(estudiante.getNombre());
        dto.setApellido(estudiante.getApellido());
        dto.setFechaNacimiento(estudiante.getFechaNacimiento());
        return dto;
    }

    private Estudiante toEntity(EstudianteDTO dto) {
        Estudiante estudiante = new Estudiante();
        estudiante.setCarnet(dto.getCarnet());
        estudiante.setNombre(dto.getNombre());
        estudiante.setApellido(dto.getApellido());
        estudiante.setFechaNacimiento(dto.getFechaNacimiento());
        return estudiante;
    }
}
