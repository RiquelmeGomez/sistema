package com.umg.sistema.service.impl;

import com.umg.sistema.dto.ProfesorDTO;
import com.umg.sistema.entities.Profesor;
import com.umg.sistema.repositories.ProfesorRepository;
import com.umg.sistema.service.ProfesorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProfesorServiceImpl implements ProfesorService {

    @Autowired
    private ProfesorRepository repository;

    // Métodos de conversión Entity <-> DTO
    private ProfesorDTO toDTO(Profesor entity) {
        ProfesorDTO dto = new ProfesorDTO();
        dto.setCodigoProfesor(entity.getCodigoProfesor());
        dto.setNombreCompleto(entity.getNombreCompleto());
        dto.setCorreo(entity.getCorreo());
        return dto;
    }

    private Profesor toEntity(ProfesorDTO dto) {
        Profesor entity = new Profesor();
        entity.setCodigoProfesor(dto.getCodigoProfesor());
        entity.setNombreCompleto(dto.getNombreCompleto());
        entity.setCorreo(dto.getCorreo());
        return entity;
    }

    @Override
    public ProfesorDTO create(ProfesorDTO dto) {
        return toDTO(repository.save(toEntity(dto)));
    }

    @Override
    public ProfesorDTO update(String codigo, ProfesorDTO dto) {
        Profesor entity = repository.findById(codigo).orElseThrow();
        entity.setNombreCompleto(dto.getNombreCompleto());
        entity.setCorreo(dto.getCorreo());
        return toDTO(repository.save(entity));
    }

    @Override
    public void delete(String codigo) {
        repository.deleteById(codigo);
    }

    @Override
    public ProfesorDTO getById(String codigo) {
        return repository.findById(codigo).map(this::toDTO).orElseThrow();
    }

    @Override
    public List<ProfesorDTO> getAll() {
        return repository.findAll().stream().map(this::toDTO).collect(Collectors.toList());
    }

    @Override
    public List<ProfesorDTO> getByNombre(String nombre) {
        return repository.findByNombreCompletoContainingIgnoreCase(nombre)
                         .stream()
                         .map(this::toDTO)
                         .collect(Collectors.toList());
    }
}
