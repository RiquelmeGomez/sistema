package com.umg.sistema.service;

import com.umg.sistema.dto.ProfesorDTO;
import java.util.List;

public interface ProfesorService {
    ProfesorDTO create(ProfesorDTO dto);
    ProfesorDTO update(String codigo, ProfesorDTO dto);
    void delete(String codigo);
    ProfesorDTO getById(String codigo);
    List<ProfesorDTO> getAll();
}