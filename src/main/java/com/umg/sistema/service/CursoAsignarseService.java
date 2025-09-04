package com.umg.sistema.service;

import com.umg.sistema.dto.CursoAsignarseDTO;
import java.util.List;

public interface CursoAsignarseService {
    CursoAsignarseDTO create(CursoAsignarseDTO dto);
    CursoAsignarseDTO update(Integer id, CursoAsignarseDTO dto);
    void delete(Integer id);
    CursoAsignarseDTO getById(Integer id);
    List<CursoAsignarseDTO> getAll();
}
