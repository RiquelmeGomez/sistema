package com.umg.sistema.service;

import com.umg.sistema.dto.EstudianteDTO;
import com.umg.sistema.dto.EstudianteInputDTO;

import java.util.List;

public interface EstudianteService {
    EstudianteDTO create(EstudianteInputDTO dto);
    EstudianteDTO update(String carnet, EstudianteInputDTO dto);
    void delete(String carnet);
    EstudianteDTO getById(String carnet);
    List<EstudianteDTO> getAll();

    // Nuevos métodos para filtros
    List<EstudianteDTO> filterByNombre(String nombre);
    List<EstudianteDTO> filterByApellido(String apellido);
}
