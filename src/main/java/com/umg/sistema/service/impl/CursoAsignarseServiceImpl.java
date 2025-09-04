package com.umg.sistema.service.impl;

import com.umg.sistema.dto.CursoAsignarseDTO;
import com.umg.sistema.entities.Curso;
import com.umg.sistema.entities.Profesor;
import com.umg.sistema.entities.CursoAsignarse;
import com.umg.sistema.repositories.CursoAsignarseRepository;
import com.umg.sistema.repositories.CursoRepository;
import com.umg.sistema.repositories.ProfesorRepository;
import com.umg.sistema.service.CursoAsignarseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CursoAsignarseServiceImpl implements CursoAsignarseService {

    @Autowired
    private CursoAsignarseRepository repository;

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private ProfesorRepository profesorRepository;

    @Override
    public CursoAsignarseDTO create(CursoAsignarseDTO dto) {
        CursoAsignarse entity = toEntity(dto);
        return toDTO(repository.save(entity));
    }

    @Override
    public CursoAsignarseDTO update(Integer id, CursoAsignarseDTO dto) {
        CursoAsignarse existente = repository.findById(id)
            .orElseThrow(() -> new RuntimeException("Registro no encontrado"));
        existente.setCurso(cursoRepository.findById(dto.getCodigoCurso())
                .orElseThrow(() -> new RuntimeException("Curso no encontrado")));
        existente.setSemestre(dto.getSemestre());
        existente.setCiclo(dto.getCiclo());
        existente.setProfesor(profesorRepository.findById(dto.getCodigoProfesor())
                .orElseThrow(() -> new RuntimeException("Profesor no encontrado")));
        return toDTO(repository.save(existente));
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public CursoAsignarseDTO getById(Integer id) {
        CursoAsignarse entity = repository.findById(id)
            .orElseThrow(() -> new RuntimeException("Registro no encontrado"));
        return toDTO(entity);
    }

    @Override
    public List<CursoAsignarseDTO> getAll() {
        return repository.findAll()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    private CursoAsignarseDTO toDTO(CursoAsignarse entity) {
        CursoAsignarseDTO dto = new CursoAsignarseDTO();
        dto.setIdCursoAsignarse(entity.getIdCursoAsignarse());
        dto.setCodigoCurso(entity.getCurso().getCodigoCurso());
        dto.setSemestre(entity.getSemestre());
        dto.setCiclo(entity.getCiclo());
        dto.setCodigoProfesor(entity.getProfesor().getCodigoProfesor());
        return dto;
    }

    private CursoAsignarse toEntity(CursoAsignarseDTO dto) {
        CursoAsignarse entity = new CursoAsignarse();
        entity.setCurso(cursoRepository.findById(dto.getCodigoCurso())
                .orElseThrow(() -> new RuntimeException("Curso no encontrado")));
        entity.setSemestre(dto.getSemestre());
        entity.setCiclo(dto.getCiclo());
        entity.setProfesor(profesorRepository.findById(dto.getCodigoProfesor())
                .orElseThrow(() -> new RuntimeException("Profesor no encontrado")));
        return entity;
    }
}
