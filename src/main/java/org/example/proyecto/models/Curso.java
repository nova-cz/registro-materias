package org.example.proyecto.models;

public class Curso {
    private String nombre;
    private String horario;
    private String locacion;
    private String categoria;
    private int cupo;

    public Curso(String nombre, String horario, String locacion, String categoria, int cupo) {
        this.nombre = nombre;
        this.horario = horario;
        this.locacion = locacion;
        this.categoria = categoria;
        this.cupo = cupo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getLocacion() {
        return locacion;
    }

    public void setLocacion(String locacion) {
        this.locacion = locacion;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getCupo() {
        return cupo;
    }

    public void setCupo(int cupo) {
        this.cupo = cupo;
    }
}
