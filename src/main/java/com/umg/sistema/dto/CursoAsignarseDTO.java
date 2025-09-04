package com.umg.sistema.dto;

public class CursoAsignarseDTO {
    private Integer idCursoAsignarse;
    private String codigoCurso;
    private Integer semestre;
    private String ciclo;
    private String codigoProfesor;

    // Getters y setters
    public Integer getIdCursoAsignarse() {
        return idCursoAsignarse;
    }

    public void setIdCursoAsignarse(Integer idCursoAsignarse) {
        this.idCursoAsignarse = idCursoAsignarse;
    }

    public String getCodigoCurso() {
        return codigoCurso;
    }

    public void setCodigoCurso(String codigoCurso) {
        this.codigoCurso = codigoCurso;
    }

    public Integer getSemestre() {
        return semestre;
    }

    public void setSemestre(Integer semestre) {
        this.semestre = semestre;
    }

    public String getCiclo() {
        return ciclo;
    }

    public void setCiclo(String ciclo) {
        this.ciclo = ciclo;
    }

    public String getCodigoProfesor() {
        return codigoProfesor;
    }

    public void setCodigoProfesor(String codigoProfesor) {
        this.codigoProfesor = codigoProfesor;
    }
}
