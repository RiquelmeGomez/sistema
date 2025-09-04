package com.umg.sistema.dtoreportes;

public class EstudiantesPorCicloDTO {
    private String ciclo;
    private Long cantidadEstudiantes;

    public EstudiantesPorCicloDTO(String ciclo, Long cantidadEstudiantes) {
        this.ciclo = ciclo;
        this.cantidadEstudiantes = cantidadEstudiantes;
    }

    // Getters
    public String getCiclo() {
        return ciclo;
    }

    public Long getCantidadEstudiantes() {
        return cantidadEstudiantes;
    }
}
