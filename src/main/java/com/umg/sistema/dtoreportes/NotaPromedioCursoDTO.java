package com.umg.sistema.dtoreportes;

public class NotaPromedioCursoDTO {
    private String nombreCurso;
    private Double notaPromedio;

    public NotaPromedioCursoDTO(String nombreCurso, Double notaPromedio) {
        this.nombreCurso = nombreCurso;
        this.notaPromedio = notaPromedio;
    }

    // Getters
    public String getNombreCurso() {
        return nombreCurso;
    }

    public Double getNotaPromedio() {
        return notaPromedio;
    }
}

