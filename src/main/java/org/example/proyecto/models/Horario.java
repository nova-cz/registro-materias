package org.example.proyecto.models;

import java.util.ArrayList;
import java.util.List;

public class Horario {
    private Alumno alumno;
    private List<Curso> listaCursos;
    private int cantMaterias;

    public Horario(Alumno alumno) {
        this.alumno = alumno;
        this.listaCursos = new ArrayList<>();
        this.cantMaterias = 0;
    }

    // Getters y setters
    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public List<Curso> getListaCursos() {
        return listaCursos;
    }

    public void setListaCursos(List<Curso> listaCursos) {
        this.listaCursos = listaCursos;
    }

    public int getCantMaterias() {
        return cantMaterias;
    }

    public void setCantMaterias(int cantMaterias) {
        this.cantMaterias = cantMaterias;
    }

    public void agregarCurso(Curso curso) {
        this.listaCursos.add(curso);
    }

}