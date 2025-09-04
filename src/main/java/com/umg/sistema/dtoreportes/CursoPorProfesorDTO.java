package com.umg.sistema.dtoreportes;

public class CursoPorProfesorDTO {
    private String nombreProfesor;
    private Long cantidadCursos;

    public CursoPorProfesorDTO(String nombreProfesor, Long cantidadCursos) {
        this.nombreProfesor = nombreProfesor;
        this.cantidadCursos = cantidadCursos;
    }

    // Getters
    public String getNombreProfesor() {
        return nombreProfesor;
    }

    public Long getCantidadCursos() {
        return cantidadCursos;
    }
}
