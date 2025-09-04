package com.umg.sistema.service.impl;

import com.umg.sistema.dto.InscripcionDTO;
import com.umg.sistema.entities.CursoAsignarse;
import com.umg.sistema.entities.Inscripcion;
import com.umg.sistema.repositories.CursoAsignarseRepository;
import com.umg.sistema.repositories.InscripcionRepository;
import com.umg.sistema.service.InscripcionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class InscripcionServiceImpl implements InscripcionService {

    @Autowired
    private InscripcionRepository repository;

    @Autowired
    private CursoAsignarseRepository cursoAsignarseRepository;

    @Override
    public InscripcionDTO create(InscripcionDTO dto) {
        CursoAsignarse curso = cursoAsignarseRepository.findById(dto.getIdCursoAsignarse())
                .orElseThrow(() -> new RuntimeException("Curso asignado no encontrado"));

        Inscripcion inscripcion = toEntity(dto, curso);
        return toDTO(repository.save(inscripcion));
    }

    @Override
    public InscripcionDTO update(Integer idInscripcion, InscripcionDTO dto) {
        Inscripcion existente = repository.findById(idInscripcion)
                .orElseThrow(() -> new RuntimeException("Inscripción no encontrada"));

        CursoAsignarse curso = cursoAsignarseRepository.findById(dto.getIdCursoAsignarse())
                .orElseThrow(() -> new RuntimeException("Curso asignado no encontrado"));

        existente.setCarnet(dto.getCarnet());
        existente.setCursoAsignarse(curso);
        existente.setNotaFinal(dto.getNotaFinal());
        existente.setFechaEvaluacion(dto.getFechaEvaluacion());

        return toDTO(repository.save(existente));
    }

    @Override
    public void delete(Integer idInscripcion) {
        repository.deleteById(idInscripcion);
    }

    @Override
    public InscripcionDTO getById(Integer idInscripcion) {
        return repository.findById(idInscripcion)
                .map(this::toDTO)
                .orElseThrow(() -> new RuntimeException("Inscripción no encontrada"));
    }

    @Override
    public List<InscripcionDTO> getAll() {
        return repository.findAll()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    // --------------------------
    // Conversión Entity <-> DTO
    // --------------------------

    private InscripcionDTO toDTO(Inscripcion inscripcion) {
        InscripcionDTO dto = new InscripcionDTO();
        dto.setIdInscripcion(inscripcion.getIdInscripcion());
        dto.setCarnet(inscripcion.getCarnet());
        dto.setIdCursoAsignarse(inscripcion.getCursoAsignarse().getIdCursoAsignarse());
        dto.setNotaFinal(inscripcion.getNotaFinal());
        dto.setFechaEvaluacion(inscripcion.getFechaEvaluacion());
        return dto;
    }

    private Inscripcion toEntity(InscripcionDTO dto, CursoAsignarse curso) {
        Inscripcion inscripcion = new Inscripcion();
        inscripcion.setCarnet(dto.getCarnet());
        inscripcion.setCursoAsignarse(curso);
        inscripcion.setNotaFinal(dto.getNotaFinal());
        inscripcion.setFechaEvaluacion(dto.getFechaEvaluacion());
        return inscripcion;
    }
}
