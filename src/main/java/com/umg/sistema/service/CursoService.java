package com.umg.sistema.service;

import com.umg.sistema.dto.CursoDTO;
import java.util.List;

public interface CursoService {
    CursoDTO create(CursoDTO dto);
    CursoDTO update(String codigoCurso, CursoDTO dto);
    void delete(String codigoCurso);
    CursoDTO getById(String codigoCurso);
    List<CursoDTO> getAll();
}
