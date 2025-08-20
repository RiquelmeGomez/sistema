package com.umg.sistema.service.impl;

import com.umg.sistema.dto.EstudianteDTO;
import com.umg.sistema.dto.EstudianteInputDTO;
import com.umg.sistema.entities.Estudiante;
import com.umg.sistema.mapper.EstudianteMapper;
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

    // Crear estudiante
    public EstudianteDTO create(EstudianteInputDTO dto) {
        Estudiante estudiante = toEntity(dto);
        Estudiante saved = repository.save(estudiante);
        return EstudianteMapper.toDTO(saved);
    }

    // Actualizar estudiante
    public EstudianteDTO update(String carnet, EstudianteInputDTO dto) {
        Estudiante existente = repository.findById(carnet)
                .orElseThrow(() -> new RuntimeException("Estudiante no encontrado"));

        existente.setNombre(dto.getNombre());
        existente.setApellido(dto.getApellido());
        existente.setFechaNacimiento(dto.getFechaNacimiento());

        Estudiante updated = repository.save(existente);
        return EstudianteMapper.toDTO(updated);
    }

    // Eliminar estudiante
    public void delete(String carnet) {
        repository.deleteById(carnet);
    }

    // Obtener estudiante por carnet
    public EstudianteDTO getById(String carnet) {
        Estudiante estudiante = repository.findById(carnet)
                .orElseThrow(() -> new RuntimeException("Estudiante no encontrado"));
        return EstudianteMapper.toDTO(estudiante);
    }

    // Obtener todos los estudiantes
    public List<EstudianteDTO> getAll() {
        return repository.findAll()
                .stream()
                .map(EstudianteMapper::toDTO)
                .collect(Collectors.toList());
    }

    // Filtrar por nombre
    public List<EstudianteDTO> filterByNombre(String nombre) {
        return repository.findByNombreContainingIgnoreCase(nombre)
                .stream()
                .map(EstudianteMapper::toDTO)
                .collect(Collectors.toList());
    }

    // Filtrar por apellido
    public List<EstudianteDTO> filterByApellido(String apellido) {
        return repository.findByApellidoContainingIgnoreCase(apellido)
                .stream()
                .map(EstudianteMapper::toDTO)
                .collect(Collectors.toList());
    }

    // Conversión InputDTO → Entidad
    private Estudiante toEntity(EstudianteInputDTO dto) {
        Estudiante estudiante = new Estudiante();
        estudiante.setCarnet(dto.getCarnet());
        estudiante.setNombre(dto.getNombre());
        estudiante.setApellido(dto.getApellido());
        estudiante.setFechaNacimiento(dto.getFechaNacimiento());
        return estudiante;
    }
}
