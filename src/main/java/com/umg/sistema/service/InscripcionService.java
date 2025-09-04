package com.umg.sistema.service;

import com.umg.sistema.dto.InscripcionDTO;
import java.util.List;

public interface InscripcionService {
    InscripcionDTO create(InscripcionDTO dto);
    InscripcionDTO update(Integer idInscripcion, InscripcionDTO dto);
    void delete(Integer idInscripcion);
    InscripcionDTO getById(Integer idInscripcion);
    List<InscripcionDTO> getAll();
}
