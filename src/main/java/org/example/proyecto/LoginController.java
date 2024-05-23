package org.example.proyecto;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.example.proyecto.models.Alumno;

import java.util.ArrayList;
import java.util.List;

public class LoginController {
    @FXML
    private TextField matriculaField;

    @FXML
    private PasswordField passwordField;
    private ActionEvent event;

    private List<Alumno> alumnos = new ArrayList<>();

    public LoginController() {
        // Ejemplo de inicialización de la lista de alumnos
        alumnos.add(new Alumno("202214548", "123", "Miguel Cruz"));
        alumnos.add(new Alumno("202215549", "456", "María"));
        alumnos.add(new Alumno("202224531", "123", "Erika Amastal"));
        alumnos.add(new Alumno("202215549", "456", "María"));
        alumnos.add(new Alumno("202213789", "156", "Bonifacio"));

    }

    @FXML
    private void handleLoginButtonAction(ActionEvent event) {
        String matricula = matriculaField.getText();
        String contraseña = passwordField.getText();

        // Busca el alumno con la matrícula ingresada
        Alumno alumno = buscarAlumnoPorMatricula(matricula);

        if (alumno != null) {
            // Verifica las credenciales del alumno
            if (alumno.getContraseña().equals(contraseña)) {
                alumno.iniciarSesion(event);
            } else {
                showAlert(Alert.AlertType.ERROR, "La autenticación falló", "Contraseña incorrecta");
            }
        } else {
            showAlert(Alert.AlertType.ERROR, "La autenticación falló", "No se encontró la matrícula");
        }
    }

    // Método para buscar un alumno por su matrícula
    private Alumno buscarAlumnoPorMatricula(String matricula) {
        for (Alumno alumno : alumnos) {
            if (alumno.getMatricula().equals(matricula)) {
                return alumno;
            }
        }
        return null; // Retorna null si no se encuentra ningún alumno con la matrícula
    }

    private void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
