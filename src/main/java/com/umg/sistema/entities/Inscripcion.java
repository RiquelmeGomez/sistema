package com.umg.sistema.entities;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "inscripcion")
public class Inscripcion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idinscripcion")
    private Integer idInscripcion;

    @Column(name = "carnet", length = 50, nullable = false)
    private String carnet;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idcursoasignarse", nullable = false)
    private CursoAsignarse cursoAsignarse;

    @Column(name = "notafinal", precision = 5, scale = 2)
    private BigDecimal notaFinal;

    @Column(name = "fechaevaluacion")
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

    public CursoAsignarse getCursoAsignarse() {
        return cursoAsignarse;
    }

    public void setCursoAsignarse(CursoAsignarse cursoAsignarse) {
        this.cursoAsignarse = cursoAsignarse;
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
