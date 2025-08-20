package com.umg.sistema.mapper;

import com.umg.sistema.dto.EstudianteDTO;
import com.umg.sistema.entities.Estudiante;

import java.time.LocalDate;
import java.time.Period;

public class EstudianteMapper {

    public static EstudianteDTO toDTO(Estudiante estudiante) {
        if (estudiante == null) return null;

        int edad = 0;
        if (estudiante.getFechaNacimiento() != null) {
            edad = Period.between(estudiante.getFechaNacimiento(), LocalDate.now()).getYears();
        }

        return new EstudianteDTO(
                estudiante.getCarnet(),
                estudiante.getNombre(),
                estudiante.getApellido(),
                edad
        );
    }
}
