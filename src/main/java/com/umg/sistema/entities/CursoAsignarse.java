package com.umg.sistema.entities;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "curso_asignarse")
public class CursoAsignarse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idcursoasignarse")
    private Integer idCursoAsignarse;

    @ManyToOne
    @JoinColumn(name = "codigocurso", referencedColumnName = "codigocurso")
    private Curso curso;

    @Column(name = "semestre", nullable = false)
    private Integer semestre;

    @Column(name = "ciclo", length = 50, nullable = false)
    private String ciclo;

    @ManyToOne
    @JoinColumn(name = "codigoprofesor", referencedColumnName = "codigoprofesor")
    private Profesor profesor;

    @OneToMany(mappedBy = "cursoAsignarse")
    private List<Inscripcion> inscripciones;

    // Getters y setters
    public Integer getIdCursoAsignarse() { 
        return idCursoAsignarse; 
    }
    public void setIdCursoAsignarse(Integer idCursoAsignarse) { this.idCursoAsignarse = idCursoAsignarse; }
    public Curso getCurso() { return curso; }
    public void setCurso(Curso curso) { this.curso = curso; }
    public Integer getSemestre() { return semestre; }
    public void setSemestre(Integer semestre) { this.semestre = semestre; }
    public String getCiclo() { return ciclo; }
    public void setCiclo(String ciclo) { this.ciclo = ciclo; }
    public Profesor getProfesor() { return profesor; }
    public void setProfesor(Profesor profesor) { this.profesor = profesor; }
    public List<Inscripcion> getInscripciones() { return inscripciones; }
    public void setInscripciones(List<Inscripcion> inscripciones) { this.inscripciones = inscripciones; }
}
