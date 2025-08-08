package com.umg.sistema.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.umg.sistema.entities.Profesor;

public interface ProfesorRepository extends JpaRepository<Profesor, String> { 
    
}