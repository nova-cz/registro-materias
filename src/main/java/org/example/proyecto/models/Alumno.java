package org.example.proyecto.models;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import kotlin.collections.EmptyList;
import org.example.proyecto.DashboardController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Alumno {
    private String matricula;
    private String contraseña;
    private String nombre;
    private Horario horario;

    // Constructor
    public Alumno(String matricula, String contraseña, String nombre) {
        this.matricula = matricula;
        this.contraseña = contraseña;
        this.nombre = nombre;
        this.horario = new Horario(this);
    }

    // Métodos getters y setters
    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Horario getHorario() {
        return horario;
    }

    public void setHorario(Horario horario) {
        this.horario = horario;
    }

    //   :3
    // Método para iniciar sesión
    public void iniciarSesion(ActionEvent event) {
        // Cargar la vista del Dashboard
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/proyecto/dashboard.fxml"));
            Parent root = loader.load();
            DashboardController dashboardController = loader.getController();
            // this.setHorario(new Horario(this, EmptyList(), 0));
            dashboardController.setHorario(horario);

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
            System.out.println("Iniciando sesión como alumno: " + nombre);

        } catch (Exception e) {
            e.printStackTrace();
            // showAlert(Alert.AlertType.ERROR, "Error", "No se pudo cargar la página principal");
        }

    }

    // Método para cerrar sesión
    public void cerrarSesion(Stage stage) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/proyecto/auth.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            // showAlert(Alert.AlertType.ERROR, "Error", "No se pudo cargar la pantalla de inicio de sesión");
        }
    }


    // Método para crear un horario
    public void crearHorario(Horario horario) {
        this.horario = horario;
        System.out.println("Horario creado para el alumno: " + nombre);
    }
}
