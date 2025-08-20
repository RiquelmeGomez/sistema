package com.umg.sistema.repositories;

import com.umg.sistema.entities.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface EstudianteRepository extends JpaRepository<Estudiante, String> {

    List<Estudiante> findByNombreContainingIgnoreCase(String nombre);
    List<Estudiante> findByApellidoContainingIgnoreCase(String apellido);
}
