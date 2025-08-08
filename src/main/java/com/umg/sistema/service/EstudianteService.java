package com.umg.sistema.service;

import com.umg.sistema.dto.EstudianteDTO;
import java.util.List;

public interface EstudianteService {
    EstudianteDTO create(EstudianteDTO dto);
    EstudianteDTO update(String carnet, EstudianteDTO dto);
    void delete(String carnet);
    EstudianteDTO getById(String carnet);
    List<EstudianteDTO> getAll();
}
