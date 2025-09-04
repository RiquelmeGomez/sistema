package com.umg.sistema.controller;

import com.umg.sistema.dtoreportes.CursoPorProfesorDTO;
import com.umg.sistema.dtoreportes.NotaPromedioCursoDTO;
import com.umg.sistema.dtoreportes.EstudiantesPorCicloDTO;
import com.umg.sistema.service.ReporteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reportes")
public class ReporteController {

    @Autowired
    private ReporteService service;

    @GetMapping("/cursos-por-profesor")
    public ResponseEntity<List<CursoPorProfesorDTO>> cursosPorProfesor() {
        return ResponseEntity.ok(service.cursosPorProfesor());
    }

    @GetMapping("/promedio-notas-curso")
    public ResponseEntity<List<NotaPromedioCursoDTO>> promedioNotasCurso() {
        return ResponseEntity.ok(service.promedioNotasPorCurso());
    }

    @GetMapping("/estudiantes-por-ciclo")
    public ResponseEntity<List<EstudiantesPorCicloDTO>> estudiantesPorCiclo() {
        return ResponseEntity.ok(service.estudiantesPorCiclo());
    }

    @GetMapping("/top3-cursos-promedio")
    public ResponseEntity<List<NotaPromedioCursoDTO>> top3CursosPromedio() {
        return ResponseEntity.ok(service.top3CursosPromedio());
    }
}
