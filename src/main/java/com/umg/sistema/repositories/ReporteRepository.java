package com.umg.sistema.repositories;

import com.umg.sistema.dtoreportes.CursoPorProfesorDTO;
import com.umg.sistema.dtoreportes.NotaPromedioCursoDTO;
import com.umg.sistema.dtoreportes.EstudiantesPorCicloDTO;
import com.umg.sistema.entities.Inscripcion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReporteRepository extends JpaRepository<Inscripcion, Long> {

    // Reporte 1: Cursos por profesor
    @Query("SELECT NEW com.umg.sistema.dtoreportes.CursoPorProfesorDTO(ca.profesor.nombreCompleto, COUNT(ca)) " +
           "FROM CursoAsignarse ca " +
           "GROUP BY ca.profesor.nombreCompleto")
    List<CursoPorProfesorDTO> contarCursosPorProfesor();

    // Reporte 2: Nota promedio por curso
    @Query("SELECT NEW com.umg.sistema.dtoreportes.NotaPromedioCursoDTO(ca.curso.nombre, AVG(i.notaFinal)) " +
           "FROM Inscripcion i JOIN i.cursoAsignarse ca " +
           "GROUP BY ca.curso.nombre")
    List<NotaPromedioCursoDTO> promedioNotasPorCurso();

    // Reporte 3: Estudiantes por ciclo
    @Query("SELECT NEW com.umg.sistema.dtoreportes.EstudiantesPorCicloDTO(ca.ciclo, COUNT(i.carnet)) " +
           "FROM Inscripcion i JOIN i.cursoAsignarse ca " +
           "GROUP BY ca.ciclo")
    List<EstudiantesPorCicloDTO> contarEstudiantesPorCiclo();

    // Reporte 4: Top 3 cursos con mejor promedio
    @Query("SELECT NEW com.umg.sistema.dtoreportes.NotaPromedioCursoDTO(ca.curso.nombre, AVG(i.notaFinal)) " +
           "FROM Inscripcion i JOIN i.cursoAsignarse ca " +
           "GROUP BY ca.curso.nombre " +
           "ORDER BY AVG(i.notaFinal) DESC")
    List<NotaPromedioCursoDTO> top3CursosPromedio();
}
