package org.example.proyecto;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;

import java.awt.*;

public class LoginController {
    @FXML
    private TextField matriculaField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private void handleLoginButtonAction() {
        String username = matriculaField.getText();
        String password = passwordField.getText();

        if (validateCredentials(username, password)) {
            showAlert(Alert.AlertType.INFORMATION, "Login Successful", "Welcome " + username);
        } else {
            showAlert(Alert.AlertType.ERROR, "Login Failed", "Invalid username or password");
        }
    }

    private boolean validateCredentials(String username, String password) {
        // Aquí se realiza la validación de las credenciales
        // Para este ejemplo, se consideran válidas las credenciales "user" y "pass"
        return "user".equals(username) && "pass".equals(password);
    }

    private void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
