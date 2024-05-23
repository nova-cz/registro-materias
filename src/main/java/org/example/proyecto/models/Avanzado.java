package org.example.proyecto.models;

public class Avanzado extends Curso {
    // Atributos específicos de la clase Basico
    private int horasLaboratorio;
    private boolean proyectoFinal;




    // Constructor de la clase Basico
    public Avanzado(String Nombre, String Horario, String Locacion, String Categoria, int Cupo, int horasLaboratorio, boolean proyectoFinal) {
        // Llamada al constructor de la clase base
        super(Nombre, Horario, Locacion, Categoria, Cupo);
        this.horasLaboratorio = horasLaboratorio;
        this.proyectoFinal = proyectoFinal;
    }

    // Getters y setters para los nuevos atributos
    public int getHorasLaboratorio() {
        return horasLaboratorio;
    }

    public void setHorasLaboratorio(int horasLaboratorio) {
        this.horasLaboratorio = horasLaboratorio;
    }

    public boolean isProyectoFinal() {
        return proyectoFinal;
    }

    public void setProyectoFinal(boolean proyectoFinal) {
        this.proyectoFinal = proyectoFinal;
    }

    public void consultarEstadoProyecto() {
        System.out.println("Consultador estado proyecto");
    }

}
