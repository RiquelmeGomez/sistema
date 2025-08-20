package com.umg.sistema.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.umg.sistema.entities.Profesor;
import java.util.List;

public interface ProfesorRepository extends JpaRepository<Profesor, String> { 
    
    // Nuevo método de consulta para filtrar por nombre
    List<Profesor> findByNombreCompletoContainingIgnoreCase(String nombre);
}