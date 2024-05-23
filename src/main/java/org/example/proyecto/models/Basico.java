package org.example.proyecto.models;

//:3

public class Basico extends Curso {
    // Atributos específicos de la clase Avanzado
    private int horasTeoria;
    private boolean examenFinal;

    // Constructor con parámetros para inicializar todos los atributos
    public Basico(String nombre, String horario, String locacion, String categoria, int cupo, int horasTeoria, boolean examenFinal) {
        // Llamada al constructor de la clase base
        super(nombre, horario, locacion, categoria, cupo);
        this.horasTeoria = horasTeoria;
        this.examenFinal = examenFinal;
    }

    // Constructor sin parámetros que establece valores predeterminados
    public Basico() {
        // Llamada al constructor de la clase base con valores predeterminados
        super("Nombre por defecto", "Horario por defecto", "Locacion por defecto", "Categoria por defecto", 0);
        this.horasTeoria = 0;
        this.examenFinal = false;
    }

    // Getters y setters para los nuevos atributos
    public int getHorasTeoria() {
        return horasTeoria;
    }

    public void setHorasTeoria(int horasTeoria) {
        this.horasTeoria = horasTeoria;
    }

    public boolean isExamenFinal() {
        return examenFinal;
    }

    public void setExamenFinal(boolean examenFinal) {
        this.examenFinal = examenFinal;
    }

    public void desbloquear(Avanzado cursoAvanzado) {
        System.out.println("Desbloqueando curso avanzado: " + cursoAvanzado.getNombre());
    }
}