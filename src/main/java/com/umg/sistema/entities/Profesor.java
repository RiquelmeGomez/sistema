 package com.umg.sistema.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "profesor") 
public class Profesor {

    @Id
    @Column(name = "codigoprofesor", length = 50) 
    private String codigoProfesor;

    @Column(name = "nombrecompleto", length = 100, nullable = false)
    private String nombreCompleto;

    @Column(name = "correo", length = 100, nullable = false)
    private String correo;

    public String getCodigoProfesor() { return codigoProfesor; }
    public void setCodigoProfesor(String codigoProfesor) { this.codigoProfesor = codigoProfesor; }

    public String getNombreCompleto() { return nombreCompleto; }
    public void setNombreCompleto(String nombreCompleto) { this.nombreCompleto = nombreCompleto; }

    public String getCorreo() { return correo; }
    public void setCorreo(String correo) { this.correo = correo; }
}
