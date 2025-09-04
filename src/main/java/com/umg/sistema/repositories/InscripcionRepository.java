package com.umg.sistema.repositories;

import com.umg.sistema.entities.Inscripcion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InscripcionRepository extends JpaRepository<Inscripcion, Integer> {
}
