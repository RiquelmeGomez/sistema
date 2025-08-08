package com.umg.sistema.service.impl;

import com.umg.sistema.dto.CursoDTO;
import com.umg.sistema.entities.Curso;
import com.umg.sistema.repositories.CursoRepository;
import com.umg.sistema.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CursoServiceImpl implements CursoService {

    @Autowired
    private CursoRepository repository;

    @Override
    public CursoDTO create(CursoDTO dto) {
        Curso curso = toEntity(dto);
        return toDTO(repository.save(curso));
    }

    @Override
    public CursoDTO update(String codigoCurso, CursoDTO dto) {
        Curso existente = repository.findById(codigoCurso)
            .orElseThrow(() -> new RuntimeException("Curso no encontrado"));
        existente.setNombre(dto.getNombre());
        existente.setCreditos(dto.getCreditos());
        return toDTO(repository.save(existente));
    }

    @Override
    public void delete(String codigoCurso) {
        repository.deleteById(codigoCurso);
    }

    @Override
    public CursoDTO getById(String codigoCurso) {
        Curso curso = repository.findById(codigoCurso)
            .orElseThrow(() -> new RuntimeException("Curso no encontrado"));
        return toDTO(curso);
    }

    @Override
    public List<CursoDTO> getAll() {
        return repository.findAll()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    private CursoDTO toDTO(Curso curso) {
        CursoDTO dto = new CursoDTO();
        dto.setCodigoCurso(curso.getCodigoCurso());
        dto.setNombre(curso.getNombre());
        dto.setCreditos(curso.getCreditos());
        return dto;
    }

    private Curso toEntity(CursoDTO dto) {
        Curso curso = new Curso();
        curso.setCodigoCurso(dto.getCodigoCurso());
        curso.setNombre(dto.getNombre());
        curso.setCreditos(dto.getCreditos());
        return curso;
    }
}
