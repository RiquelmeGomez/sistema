package com.umg.sistema.service.impl;

import com.umg.sistema.dtoreportes.CursoPorProfesorDTO;
import com.umg.sistema.dtoreportes.NotaPromedioCursoDTO;
import com.umg.sistema.dtoreportes.EstudiantesPorCicloDTO;
import com.umg.sistema.repositories.ReporteRepository;
import com.umg.sistema.service.ReporteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReporteServiceImpl implements ReporteService {

    @Autowired
    private ReporteRepository repository;

    @Override
    public List<CursoPorProfesorDTO> cursosPorProfesor() {
        return repository.contarCursosPorProfesor();
    }

    @Override
    public List<NotaPromedioCursoDTO> promedioNotasPorCurso() {
        return repository.promedioNotasPorCurso();
    }

    @Override
    public List<EstudiantesPorCicloDTO> estudiantesPorCiclo() {
        return repository.contarEstudiantesPorCiclo();
    }

    @Override
    public List<NotaPromedioCursoDTO> top3CursosPromedio() {
        List<NotaPromedioCursoDTO> lista = repository.top3CursosPromedio();
        return lista.size() > 3 ? lista.subList(0, 3) : lista;
    }
}
