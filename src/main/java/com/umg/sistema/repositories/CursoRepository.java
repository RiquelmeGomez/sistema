package com.umg.sistema.repositories;

import com.umg.sistema.entities.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CursoRepository extends JpaRepository<Curso, String> {

    // Nuevo método de consulta para filtrar por nombre
    List<Curso> findByNombreContainingIgnoreCase(String nombre);
}
