package com.umg.sistema.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class InscripcionDTO {

    private Integer idInscripcion;
    private String carnet;
    private Integer idCursoAsignarse;
    private BigDecimal notaFinal;
    private LocalDate fechaEvaluacion;

    // Getters y setters

    public Integer getIdInscripcion() {
        return idInscripcion;
    }

    public void setIdInscripcion(Integer idInscripcion) {
        this.idInscripcion = idInscripcion;
    }

    public String getCarnet() {
        return carnet;
    }

    public void setCarnet(String carnet) {
        this.carnet = carnet;
    }

    public Integer getIdCursoAsignarse() {
        return idCursoAsignarse;
    }

    public void setIdCursoAsignarse(Integer idCursoAsignarse) {
        this.idCursoAsignarse = idCursoAsignarse;
    }

    public BigDecimal getNotaFinal() {
        return notaFinal;
    }

    public void setNotaFinal(BigDecimal notaFinal) {
        this.notaFinal = notaFinal;
    }

    public LocalDate getFechaEvaluacion() {
        return fechaEvaluacion;
    }

    public void setFechaEvaluacion(LocalDate fechaEvaluacion) {
        this.fechaEvaluacion = fechaEvaluacion;
    }
}
