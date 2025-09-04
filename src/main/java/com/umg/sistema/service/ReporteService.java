package com.umg.sistema.service;

import com.umg.sistema.dtoreportes.CursoPorProfesorDTO;
import com.umg.sistema.dtoreportes.NotaPromedioCursoDTO;
import com.umg.sistema.dtoreportes.EstudiantesPorCicloDTO;

import java.util.List;

public interface ReporteService {
    List<CursoPorProfesorDTO> cursosPorProfesor();
    List<NotaPromedioCursoDTO> promedioNotasPorCurso();
    List<EstudiantesPorCicloDTO> estudiantesPorCiclo();
    List<NotaPromedioCursoDTO> top3CursosPromedio();
}

